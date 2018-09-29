package khurkham.com.android.learntailanguage;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.List;
import khurkham.com.android.learntailanguage.constants.NavigationDrawerConstants;
import khurkham.com.android.learntailanguage.fragments.MyAppFragment;
import khurkham.com.android.learntailanguage.infrastructure.AppSection;
import khurkham.com.android.learntailanguage.infrastructure.MyAppFragmentFactory;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentManager.OnBackStackChangedListener {

    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    private static String INSTANCE_TOOLBAR_USE_DRAWER = "toolbar_drawer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FontsOverride.setDefaultFont(this, "MONOSPACE", "namteng.ttf");


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // let the fragment manager know that MainActivity will be listening to events
        getSupportFragmentManager().addOnBackStackChangedListener(this);

        /*
         AppBar setup
         */
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getSupportFragmentManager().getBackStackEntryCount() > 0)
                    onBackPressed();
            }
        });

        if (savedInstanceState == null) {

            /*
            app should start on the home section
            notice we won't be adding it to the back stack. Pressing back
            should exist the app
            */
            navigateToSection(AppSection.HOME, false);
            navigationView.setCheckedItem(R.id.nav_home);
        } else {
            /*
            the app has been recreated, we can obtain the saved state and restore the looks of the toolbar
             */
            AppBarState savedAppBarState = (AppBarState) savedInstanceState.getSerializable(INSTANCE_TOOLBAR_USE_DRAWER);
            if (savedAppBarState == AppBarState.USE_DRAWER)
                showRootNavigation();
            else
                showBackArrowNavigation();
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        /*
        the app will be recreated and the current toolbar will be null. It will be recreated
        when the onCreate method is called. Store the current state to rebuild the toolbar correctly
         */
        AppBarState currentApbAppBarState = AppBarState.USE_DRAWER;
        MyAppFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            currentApbAppBarState = currentFragment.getIsRootSection() ? AppBarState.USE_DRAWER : AppBarState.USE_BACK_NAVIGATION;
        }
        // store this value on the state
        outState.putSerializable(INSTANCE_TOOLBAR_USE_DRAWER, currentApbAppBarState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            navigateToSection(AppSection.ABOUT, true);
        } else if (id == R.id.nav_referable) {
            navigateToSection(AppSection.REFERABLE, true);
        } else if (id == R.id.nav_home) {
            navigateToSection(AppSection.HOME, false); // the boolean here will not do anything
        } else if (id == R.id.nav_appmore) {
            openAppRating(this);
        }else if (id == R.id.nav_send) {
            openAppRating1(this);
        } else if (id == R.id.nav_share) {
            //Display Share Via dialogue
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType(NavigationDrawerConstants.SHARE_TEXT_TYPE);
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, NavigationDrawerConstants.SHARE_TITLE);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, NavigationDrawerConstants.SHARE_MESSAGE);
            startActivity(Intent.createChooser(sharingIntent, NavigationDrawerConstants.SHARE_VIA));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Navigates to a fragment within the app
     *
     * @param section    where to go
     * @param addToStack should this transaction be added to the back stack ?
     */
    public void navigateToSection(AppSection section, boolean addToStack) {

        // obtain the fragment we want to navigate to
        MyAppFragment fragment = MyAppFragmentFactory.getFragment(section);

        // if this is a root fragment, clear everything up to the home and add this one
        if (fragment.getIsRootSection())
            getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        // normal transaction stuff
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragment, fragment.getFragmentTag());
        if (addToStack)
            fragmentTransaction.addToBackStack(fragment.getFragmentTag());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackStackChanged() {
        MyAppFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {

            // since we are here, we can update the selected item on the sidebar
            setNavigationViewCheckedItem(currentFragment);

            if (currentFragment.getIsRootSection()) {
                showRootNavigation();
            } else {
                // this is not a "root" fragment. Use back arrow navigation on the app bar
                showBackArrowNavigation();
            }
        }
    }


    /**
     * Updates the sidebar according to a specific fragment
     *
     * @param fragment fragment being shown
     */
    private void setNavigationViewCheckedItem(MyAppFragment fragment) {
        if (fragment.getFragmentTag().equals(AppSection.HOME.toString()))
            navigationView.setCheckedItem(R.id.nav_home);
        else if (fragment.getFragmentTag().equals(AppSection.ABOUT.toString()))
            navigationView.setCheckedItem(R.id.nav_about);
        else if (fragment.getFragmentTag().equals(AppSection.REFERABLE.toString()))
            navigationView.setCheckedItem(R.id.nav_referable);
        else if (id == R.id.nav_share) {
            //Display Share Via dialogue
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType(NavigationDrawerConstants.SHARE_TEXT_TYPE);
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, NavigationDrawerConstants.SHARE_TITLE);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, NavigationDrawerConstants.SHARE_MESSAGE);
            startActivity(Intent.createChooser(sharingIntent, NavigationDrawerConstants.SHARE_VIA));
        }
    }

    /**
     * Get the current visible MyAppFragment.
     *
     * @return current visible MyAppFragment. null if the stack is empty or fragment is not MyAppFragment
     */
    private MyAppFragment getCurrentFragment() {
        List<Fragment> fragmentStack = getSupportFragmentManager().getFragments();
        if (fragmentStack == null || fragmentStack.size() == 0)
            return null;

        for (Fragment current : fragmentStack) {
            if (current != null && current.isVisible() && (current instanceof MyAppFragment))
                return (MyAppFragment) current;
        }

        return null;
    }

    //region application bar

    /**
     * Display the hamburger icon on the application bar
     */
    private void showRootNavigation() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    /**
     * Display the back arrow on the application bar
     */
    private void showBackArrowNavigation() {
        // order of these calls IS important
        toggle.setDrawerIndicatorEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }
    //endregion

    //region support

    private enum AppBarState {
        USE_DRAWER,
        USE_BACK_NAVIGATION,
    }
    //endregion


    //like ဢၼ်ၼႆႉ လုၵ်ႉဢဝ်တီႈ nav_appmore ၵႂႃႇတီႈ web ၵမ်းသိုဝ်ႈ


    public static void openAppRating(Context context) {
        Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://developer?id=Khurkham+Langkhur"));
        boolean marketFound = false;

        // find all applications able to handle our rateIntent
        final List<ResolveInfo> otherApps = context.getPackageManager().queryIntentActivities(rateIntent, 0);
        for (ResolveInfo otherApp : otherApps) {
            // look for Google Play application
            if (otherApp.activityInfo.applicationInfo.packageName.equals("com.android.khurkhamlangkhur" +
                    "")) {

                ActivityInfo otherAppActivity = otherApp.activityInfo;
                ComponentName componentName = new ComponentName(
                        otherAppActivity.applicationInfo.packageName,
                        otherAppActivity.name
                );
                rateIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                rateIntent.setComponent(componentName);
                context.startActivity(rateIntent);
                marketFound = true;
                break;

            }
        }

        // if GP not present on device, open web browser
        if (!marketFound) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Khurkham+Langkhur"));
            context.startActivity(webIntent);
        }
    }

    //လိၵ်ႉၵႂႃႇတီႈ facebook inbox

    public static void openAppRating1(Context context) {
        boolean marketFound = false;

        // if GP not present on device, open web browser
        if (!marketFound) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Khurkham/inbox/"));
            context.startActivity(webIntent);
        }
    }
}
