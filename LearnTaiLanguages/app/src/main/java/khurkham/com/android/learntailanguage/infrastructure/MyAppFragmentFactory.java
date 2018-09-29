package khurkham.com.android.learntailanguage.infrastructure;

import khurkham.com.android.learntailanguage.fragments.FragmentHome;
import khurkham.com.android.learntailanguage.fragments.FragmentImore;
import khurkham.com.android.learntailanguage.fragments.FragmentAbout;
import khurkham.com.android.learntailanguage.fragments.FragmentReferable;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle1;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle11;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle12;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle13;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle2;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle3;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle4;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle41;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle42;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle43;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle5;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle51;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle52;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle53;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle6;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle61;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle611;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle612;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle613;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle62;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle621;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle622;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle623;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle7;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle71;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle72;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle73;
import khurkham.com.android.learntailanguage.fragments.Fragmenttitle74;
import khurkham.com.android.learntailanguage.fragments.MyAppFragment;

/**
 * Created by angel on 2/2/2018.
 */

public class MyAppFragmentFactory {

    public static MyAppFragment getFragment(AppSection section) {
        switch (section) {
            case HOME:
                return new FragmentHome();
            case REFERABLE:
                return new FragmentReferable();
            case ABOUT:
                return new FragmentAbout();
            case MORE:
                return new FragmentImore();

            case TITLE1:
                return new Fragmenttitle1();
            case TITLE2:
                return new Fragmenttitle2();
            case TITLE3:
                return new Fragmenttitle3();
            case TITLE4:
                return new Fragmenttitle4();
            case TITLE5:
                return new Fragmenttitle5();
            case TITLE6:
                return new Fragmenttitle6();
            case TITLE7:
                return new Fragmenttitle7();

            case TITLE11:
                return new Fragmenttitle11();
            case TITLE12:
                return new Fragmenttitle12();
            case TITLE13:
                return new Fragmenttitle13();

            case TITLE41:
                return new Fragmenttitle41();
            case TITLE42:
                return new Fragmenttitle42();
            case TITLE43:
                return new Fragmenttitle43();

            case TITLE51:
                return new Fragmenttitle51();
            case TITLE52:
                return new Fragmenttitle52();
            case TITLE53:
                return new Fragmenttitle53();

            case TITLE61:
                return new Fragmenttitle61();
            case TITLE62:
                return new Fragmenttitle62();

            case TITLE71:
                return new Fragmenttitle71();
            case TITLE72:
                return new Fragmenttitle72();
            case TITLE73:
                return new Fragmenttitle73();
            case TITLE74:
                return new Fragmenttitle74();

            case TITLE611:
                return new Fragmenttitle611();
            case TITLE612:
                return new Fragmenttitle612();
            case TITLE613:
                return new Fragmenttitle613();
            
            case TITLE621:
                return new Fragmenttitle621();
            case TITLE622:
                return new Fragmenttitle622();
            case TITLE623:
                return new Fragmenttitle623();
            default:
                return null;
        }
    }
}
