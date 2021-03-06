package com.instify.android.ux;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntro2Fragment;
import com.instify.android.R;
import com.instify.android.app.AppController;

/**
 * An example full-screen activity that shows and hides the system ui (i.e.
 * status bar and navigation/system bar) with user interaction.
 */

public class IntroActivity extends AppIntro2 {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Add your slide's fragments here.
    // AppIntro will automatically generate the dots indicator and buttons.
    addSlide(AppIntro2Fragment.newInstance("What's Trending",
        "Stay updates on latest announcements/events in the university", R.drawable.img_srm_logo,
        getResources().getColor(R.color.blue_grey_primary)));

    addSlide(AppIntro2Fragment.newInstance("Attendance Genie",
        "View all your Marks info in this page. We provide you with statistical data that will help to make difficult choices",
        R.drawable.img_srm_logo, getResources().getColor(R.color.red_primary)));

    addSlide(AppIntro2Fragment.newInstance("Notes catalog", "See all your notes in one place",
        R.drawable.img_srm_logo, getResources().getColor(R.color.orange_primary)));

    addSlide(AppIntro2Fragment.newInstance("Day's Schedule",
        "Keep forgetting which hour will be next? No worries, Instify is here to help!",
        R.drawable.img_srm_logo, getResources().getColor(R.color.green_primary)));

    addSlide(AppIntro2Fragment.newInstance("University Updates",
        "News/Announcements on the website directly pushed to your device", R.drawable.img_srm_logo,
        getResources().getColor(R.color.colorPrimary)));

    // Set required animation
    setFadeAnimation();

    // Hide Skip/Done button.
    showSkipButton(true);
    setProgressButtonEnabled(true);

    // Turn vibration on and set intensity.
    // NOTE: you will probably need to ask VIBRATE permission in Manifest.
    setVibrate(true);
    setVibrateIntensity(50);

    // This will ask for the camera permission AND the contacts permission on the same slide.
    // Ensure your slide talks about both so as not to confuse the user.
    // askForPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_CONTACTS}, 2);
  }

  @Override public void onSkipPressed(Fragment currentFragment) {
    setIsFirstRunFalse();
    startActivity(new Intent(this, LoginActivity.class));
    finish();
  }

  @Override public void onDonePressed(Fragment currentFragment) {
    setIsFirstRunFalse();
    startActivity(new Intent(this, LoginActivity.class));
    finish();
  }

  @Override
  public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
    super.onSlideChanged(oldFragment, newFragment);
    // Do something when the slide changes.
  }

  public void setIsFirstRunFalse() {
    // Set isFirstRun Boolean value to false
    AppController.getInstance().getPrefManager().setIsFirstRun(false);
  }
}