package com.leestream.custombottomnavigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.leestream.custombottomnavigationbar.Fragments.HomeFragment;
import com.leestream.custombottomnavigationbar.Fragments.ProfileFragment;
import com.leestream.custombottomnavigationbar.Fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav=findViewById(R.id.bottomNav);

        bottomNav.add(new MeowBottomNavigation.Model(1,R.drawable.ic_home_foreground));
        bottomNav.add(new MeowBottomNavigation.Model(2,R.drawable.ic_settings_foreground));
        bottomNav.add(new MeowBottomNavigation.Model(3,R.drawable.ic_profile_foreground));

        //adding count
//        bottomNav.setCount(2,"15");

        // clearing count
//        bottomNavigation.clearCount(TAB_ID);

        bottomNav.setOnShowListener(item -> {
            Fragment fragment=null;
            switch (item.getId()){
                case 1:
                    fragment=new HomeFragment();
                    break;
                case 2:
                    fragment=new SettingsFragment();
                    break;
                case 3:
                    fragment=new ProfileFragment();
                    break;
            }
            loadFragment(fragment);
        });

        bottomNav.show(1,true);

        bottomNav.setOnClickMenuListener(item -> showToast(item.getId()+ "is Clicked"));

        bottomNav.setOnReselectListener(item -> showToast(item.getId()+ " Reselected"));

    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout,fragment)
                .commit();
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}