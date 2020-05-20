package it.feio.android.omninotes;

import android.Manifest;
import android.os.SystemClock;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.CoordinatesProvider;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.action.Tap;
import androidx.test.espresso.action.ViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static it.feio.android.omninotes.IsEqualTrimmingAndIgnoringCase.equalToTrimmingAndIgnoringCase;
import static it.feio.android.omninotes.VisibleViewMatcher.isVisible;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> mActivityTestRule =
      new ActivityTestRule<>(MainActivity.class);

  @Rule
  public GrantPermissionRule permissionRule =
      GrantPermissionRule.grant(Manifest.permission.RECORD_AUDIO,
          Manifest.permission.ACCESS_COARSE_LOCATION);

  @Test
  public void mainActivityTest () {
    ViewInteraction android_widget_TextView =
        onView(
            allOf(
                withId(R.id.empty_list),
                withTextOrHint(equalToTrimmingAndIgnoringCase("Nothing here!")),
                isVisible(),
                isDescendantOfA(
                    allOf(
                        withId(R.id.list_root),
                        isDescendantOfA(
                            allOf(
                                withId(R.id.fragment_container),
                                isDescendantOfA(withId(R.id.drawer_layout))))))));
    android_widget_TextView.perform(getClickAction());

    ViewInteraction android_widget_ImageButton =
        onView(
            allOf(
                withId(R.id.fab_checklist),
                isVisible(),
                isDescendantOfA(
                    allOf(
                        withId(R.id.fab),
                        isDescendantOfA(
                            allOf(
                                withId(R.id.fragment_container),
                                isDescendantOfA(withId(R.id.drawer_layout))))))));
    android_widget_ImageButton.perform(getClickAction());

    ViewInteraction android_widget_ImageView =
        onView(
            allOf(
                withContentDescription(equalToTrimmingAndIgnoringCase("More options")),
                isVisible(),
                isDescendantOfA(
                    allOf(withId(R.id.toolbar), isDescendantOfA(withId(R.id.drawer_layout))))));
    android_widget_ImageView.perform(getLongClickAction());

    ViewInteraction root = onView(isRoot());
    root.perform(getSwipeAction(540, 897, 540, 0));

    waitToScrollEnd();

    ViewInteraction android_widget_ImageButton2 =
        onView(
            allOf(
                withId(R.id.fab_expand_menu_button),
                isVisible(),
                isDescendantOfA(
                    allOf(
                        withId(R.id.fab),
                        isDescendantOfA(
                            allOf(
                                withId(R.id.fragment_container),
                                isDescendantOfA(withId(R.id.drawer_layout))))))));
    android_widget_ImageButton2.perform(getLongClickAction());

    ViewInteraction android_widget_TextView2 =
        onView(
            allOf(
                withId(R.id.empty_list),
                withTextOrHint(equalToTrimmingAndIgnoringCase("Nothing here!")),
                isVisible(),
                isDescendantOfA(
                    allOf(
                        withId(R.id.list_root),
                        isDescendantOfA(
                            allOf(
                                withId(R.id.fragment_container),
                                isDescendantOfA(withId(R.id.drawer_layout))))))));
    android_widget_TextView2.perform(getClickAction());

    ViewInteraction android_widget_ImageButton3 =
        onView(
            allOf(
                withId(R.id.fab_note),
                isVisible(),
                isDescendantOfA(
                    allOf(
                        withId(R.id.fab),
                        isDescendantOfA(
                            allOf(
                                withId(R.id.fragment_container),
                                isDescendantOfA(withId(R.id.drawer_layout))))))));
    android_widget_ImageButton3.perform(getClickAction());

    ViewInteraction root2 = onView(isRoot());
    root2.perform(getSwipeAction(540, 897, 540, 1794));

    waitToScrollEnd();

    ViewInteraction android_widget_ImageButton4 =
        onView(
            allOf(
                withContentDescription(equalToTrimmingAndIgnoringCase("drawer open")),
                isVisible(),
                isDescendantOfA(
                    allOf(withId(R.id.toolbar), isDescendantOfA(withId(R.id.drawer_layout))))));
    android_widget_ImageButton4.perform(getClickAction());

    ViewInteraction root3 = onView(isRoot());
    root3.perform(getSwipeAction(540, 897, 540, 0));

    waitToScrollEnd();

    ViewInteraction android_widget_ImageView2 =
        onView(
            allOf(
                withContentDescription(equalToTrimmingAndIgnoringCase("More options")),
                isVisible(),
                isDescendantOfA(
                    allOf(withId(R.id.toolbar), isDescendantOfA(withId(R.id.drawer_layout))))));
    android_widget_ImageView2.perform(getClickAction());

    ViewInteraction root4 = onView(isRoot());
    root4.perform(getSwipeAction(540, 897, 540, 1794));

    waitToScrollEnd();

    ViewInteraction android_widget_ImageButton5 =
        onView(
            allOf(
                withId(R.id.fab_checklist),
                isVisible(),
                isDescendantOfA(
                    allOf(
                        withId(R.id.fab),
                        isDescendantOfA(
                            allOf(
                                withId(R.id.fragment_container),
                                isDescendantOfA(withId(R.id.drawer_layout))))))));
    android_widget_ImageButton5.perform(getClickAction());

    ViewInteraction android_widget_ImageView3 =
        onView(
            allOf(
                withContentDescription(equalToTrimmingAndIgnoringCase("More options")),
                isVisible(),
                isDescendantOfA(
                    allOf(withId(R.id.toolbar), isDescendantOfA(withId(R.id.drawer_layout))))));
    android_widget_ImageView3.perform(getClickAction());

    ViewInteraction android_widget_LinearLayout =
        onView(
            allOf(
                classOrSuperClassesName(is("android.widget.LinearLayout")),
                isVisible(),
                hasDescendant(
                    allOf(
                        withId(R.id.title),
                        withTextOrHint(equalToTrimmingAndIgnoringCase("Disable checklist"))))));
    android_widget_LinearLayout.perform(getClickAction());

    Espresso.pressBackUnconditionally();

    ViewInteraction android_widget_ImageView4 =
        onView(
            allOf(
                withContentDescription(equalToTrimmingAndIgnoringCase("More options")),
                isVisible(),
                isDescendantOfA(
                    allOf(withId(R.id.toolbar), isDescendantOfA(withId(R.id.drawer_layout))))));
    android_widget_ImageView4.perform(getLongClickAction());

    ViewInteraction android_widget_EditText =
        onView(
            allOf(
                withId(R.id.detail_title),
                withTextOrHint(equalToTrimmingAndIgnoringCase("Title")),
                isVisible(),
                isDescendantOfA(
                    allOf(
                        withId(R.id.title_wrapper),
                        isDescendantOfA(
                            allOf(
                                withId(R.id.detail_tile_card),
                                isDescendantOfA(
                                    allOf(
                                        withId(R.id.detail_wrapper),
                                        isDescendantOfA(
                                            allOf(
                                                withId(R.id.detail_root),
                                                isDescendantOfA(
                                                    allOf(
                                                        withId(R.id.fragment_container),
                                                        isDescendantOfA(
                                                            withId(R.id.drawer_layout))))))))))))));
    android_widget_EditText.perform(replaceText("readdressing"));

    ViewInteraction android_widget_LinearLayout2 =
        onView(
            allOf(
                withId(R.id.reminder_layout),
                isVisible(),
                hasDescendant(withId(R.id.reminder_icon)),
                hasDescendant(
                    allOf(
                        withId(R.id.datetime),
                        withTextOrHint(equalToTrimmingAndIgnoringCase("Add reminder")))),
                isDescendantOfA(
                    allOf(
                        withId(R.id.content_wrapper),
                        isDescendantOfA(
                            allOf(
                                withId(R.id.detail_content_card),
                                isDescendantOfA(
                                    allOf(
                                        withId(R.id.detail_wrapper),
                                        isDescendantOfA(
                                            allOf(
                                                withId(R.id.detail_root),
                                                isDescendantOfA(
                                                    allOf(
                                                        withId(R.id.fragment_container),
                                                        isDescendantOfA(
                                                            withId(R.id.drawer_layout))))))))))))));
    android_widget_LinearLayout2.perform(getClickAction());

    Espresso.pressBackUnconditionally();

    ViewInteraction android_widget_EditText2 =
        onView(
            allOf(
                withId(R.id.detail_title),
                withTextOrHint(equalToTrimmingAndIgnoringCase("readdressing")),
                isVisible(),
                isDescendantOfA(
                    allOf(
                        withId(R.id.title_wrapper),
                        isDescendantOfA(
                            allOf(
                                withId(R.id.detail_tile_card),
                                isDescendantOfA(
                                    allOf(
                                        withId(R.id.detail_wrapper),
                                        isDescendantOfA(
                                            allOf(
                                                withId(R.id.detail_root),
                                                isDescendantOfA(
                                                    allOf(
                                                        withId(R.id.fragment_container),
                                                        isDescendantOfA(
                                                            withId(R.id.drawer_layout))))))))))))));
    android_widget_EditText2.perform(replaceText("theodicies"));

    ViewInteraction android_widget_TextView3 =
        onView(
            allOf(
                withId(R.id.menu_attachment),
                isVisible(),
                isDescendantOfA(
                    allOf(withId(R.id.toolbar), isDescendantOfA(withId(R.id.drawer_layout))))));
    android_widget_TextView3.perform(getClickAction());

//    ViewInteraction android_widget_TextView4 =
//        onView(
//            allOf(
//                withId(R.id.sketch),
//                withTextOrHint(equalToTrimmingAndIgnoringCase("Sketch")),
//                isVisible(),
//                isDescendantOfA(
//                    allOf(
//                        withId(R.id.attachment_dialog_root),
//                        isDescendantOfA(
//                            allOf(
//                                withId(R.id.customViewFrame),
//                                isDescendantOfA(withId(R.id.root))))))));
//    android_widget_TextView4.perform(getClickAction());

    ViewInteraction android_widget_ImageView5 =
        onView(
            allOf(
                withId(R.id.sketch_eraser),
                isVisible(),
                isDescendantOfA(
                    allOf(
                        withId(R.id.eraserView),
                        isDescendantOfA(
                            allOf(
                                withId(R.id.drawing_question),
                                isDescendantOfA(
                                    allOf(
                                        withId(R.id.fragment_container),
                                        isDescendantOfA(withId(R.id.drawer_layout))))))))));
    android_widget_ImageView5.perform(getClickAction());

    Espresso.pressBackUnconditionally();

    ViewInteraction android_widget_TextView5 =
        onView(
            allOf(
                withId(R.id.menu_attachment),
                isVisible(),
                isDescendantOfA(
                    allOf(withId(R.id.toolbar), isDescendantOfA(withId(R.id.drawer_layout))))));
    android_widget_TextView5.perform(getClickAction());

//    ViewInteraction android_widget_TextView6 =
//        onView(
//            allOf(
//                withId(R.id.recording),
//                withTextOrHint(equalToTrimmingAndIgnoringCase("Record")),
//                isVisible(),
//                isDescendantOfA(
//                    allOf(
//                        withId(R.id.attachment_dialog_root),
//                        isDescendantOfA(
//                            allOf(
//                                withId(R.id.customViewFrame),
//                                isDescendantOfA(withId(R.id.root))))))));
//    android_widget_TextView6.perform(getClickAction());
//
//    ViewInteraction android_widget_TextView7 =
//        onView(
//            allOf(
//                withId(R.id.timestamp),
//                withTextOrHint(equalToTrimmingAndIgnoringCase("Timestamp")),
//                isVisible(),
//                isDescendantOfA(
//                    allOf(
//                        withId(R.id.attachment_dialog_root),
//                        isDescendantOfA(
//                            allOf(
//                                withId(R.id.customViewFrame),
//                                isDescendantOfA(withId(R.id.root))))))));
//    android_widget_TextView7.perform(getClickAction());
//
//    ViewInteraction android_widget_TextView8 =
//        onView(
//            allOf(
//                withId(R.id.location),
//                withTextOrHint(equalToTrimmingAndIgnoringCase("Location")),
//                isVisible(),
//                isDescendantOfA(
//                    allOf(
//                        withId(R.id.attachment_dialog_root),
//                        isDescendantOfA(
//                            allOf(
//                                withId(R.id.customViewFrame),
//                                isDescendantOfA(withId(R.id.root))))))));
//    android_widget_TextView8.perform(getClickAction());
//
//    ViewInteraction android_widget_EditText3 =
//        onView(
//            allOf(
//                withId(R.id.auto_complete_location),
//                withTextOrHint(equalToTrimmingAndIgnoringCase("Search location")),
//                isVisible(),
//                isDescendantOfA(
//                    allOf(withId(R.id.customViewFrame), isDescendantOfA(withId(R.id.root))))));
//    android_widget_EditText3.perform(replaceText("reperusal"));
//
//    ViewInteraction android_widget_EditText4 =
//        onView(
//            allOf(
//                withId(R.id.auto_complete_location),
//                withTextOrHint(equalToTrimmingAndIgnoringCase("reperusal")),
//                isVisible(),
//                isDescendantOfA(
//                    allOf(withId(R.id.customViewFrame), isDescendantOfA(withId(R.id.root))))));
//    android_widget_EditText4.perform(replaceText("dozen"));
//
//    ViewInteraction android_widget_TextView9 =
//        onView(
//            allOf(
//                withId(R.id.buttonDefaultPositive),
//                withTextOrHint(equalToTrimmingAndIgnoringCase("CONFIRM")),
//                isVisible(),
//                isDescendantOfA(withId(R.id.root))));
//    android_widget_TextView9.perform(getClickAction());
//
//    ViewInteraction android_widget_TextView10 =
//        onView(
//            allOf(
//                withId(R.id.timestamp),
//                withTextOrHint(equalToTrimmingAndIgnoringCase("Timestamp")),
//                isVisible(),
//                isDescendantOfA(
//                    allOf(
//                        withId(R.id.attachment_dialog_root),
//                        isDescendantOfA(
//                            allOf(
//                                withId(R.id.customViewFrame),
//                                isDescendantOfA(withId(R.id.root))))))));
//    android_widget_TextView10.perform(getClickAction());
//
//    ViewInteraction android_widget_TextView11 =
//        onView(
//            allOf(
//                withId(R.id.recording),
//                withTextOrHint(equalToTrimmingAndIgnoringCase("Stop")),
//                isVisible(),
//                isDescendantOfA(
//                    allOf(
//                        withId(R.id.attachment_dialog_root),
//                        isDescendantOfA(
//                            allOf(
//                                withId(R.id.customViewFrame),
//                                isDescendantOfA(withId(R.id.root))))))));
//    android_widget_TextView11.perform(getClickAction());

    ViewInteraction android_widget_ImageView6 =
        onView(
            allOf(
                withContentDescription(equalToTrimmingAndIgnoringCase("More options")),
                isVisible(),
                isDescendantOfA(
                    allOf(withId(R.id.toolbar), isDescendantOfA(withId(R.id.drawer_layout))))));
    android_widget_ImageView6.perform(getClickAction());

    ViewInteraction android_widget_LinearLayout3 =
        onView(
            allOf(
                classOrSuperClassesName(is("android.widget.LinearLayout")),
                isVisible(),
                hasDescendant(
                    allOf(
                        withId(R.id.title),
                        withTextOrHint(equalToTrimmingAndIgnoringCase("Enable checklist"))))));
    android_widget_LinearLayout3.perform(getClickAction());

    ViewInteraction root5 = onView(isRoot());
    root5.perform(getSwipeAction(540, 897, 540, 1794));

    waitToScrollEnd();

    ViewInteraction root6 = onView(isRoot());
    root6.perform(getSwipeAction(540, 897, 540, 1794));

    waitToScrollEnd();

    ViewInteraction android_widget_TextView12 =
        onView(
            allOf(
                withId(R.id.menu_tag),
                isVisible(),
                isDescendantOfA(
                    allOf(withId(R.id.toolbar), isDescendantOfA(withId(R.id.drawer_layout))))));
    android_widget_TextView12.perform(getClickAction());

    ViewInteraction android_widget_TextView13 =
        onView(
            allOf(
                withId(R.id.menu_share),
                isVisible(),
                isDescendantOfA(
                    allOf(withId(R.id.toolbar), isDescendantOfA(withId(R.id.drawer_layout))))));
    android_widget_TextView13.perform(getClickAction());
  }

  private static Matcher<View> classOrSuperClassesName (final Matcher<String> classNameMatcher) {

    return new TypeSafeMatcher<View>() {
      @Override
      public void describeTo (Description description) {
        description.appendText("Class name or any super class name ");
        classNameMatcher.describeTo(description);
      }

      @Override
      public boolean matchesSafely (View view) {
        Class<?> clazz = view.getClass();
        String canonicalName;

        do {
          canonicalName = clazz.getCanonicalName();
          if (canonicalName == null) {
            return false;
          }

          if (classNameMatcher.matches(canonicalName)) {
            return true;
          }

          clazz = clazz.getSuperclass();
          if (clazz == null) {
            return false;
          }
        } while (!"java.lang.Object".equals(canonicalName));

        return false;
      }
    };
  }

  private static Matcher<View> withTextOrHint (final Matcher<String> stringMatcher) {
    return anyOf(withText(stringMatcher), withHint(stringMatcher));
  }

  private ViewAction getSwipeAction (
      final int fromX, final int fromY, final int toX, final int toY) {
    return ViewActions.actionWithAssertions(
        new GeneralSwipeAction(
            Swipe.SLOW,
            new CoordinatesProvider() {
              @Override
              public float[] calculateCoordinates (View view) {
                float[] coordinates = {fromX, fromY};
                return coordinates;
              }
            },
            new CoordinatesProvider() {
              @Override
              public float[] calculateCoordinates (View view) {
                float[] coordinates = {toX, toY};
                return coordinates;
              }
            },
            Press.FINGER));
  }

  private void waitToScrollEnd () {
    SystemClock.sleep(500);
  }

  private ClickWithoutDisplayConstraint getClickAction () {
    return new ClickWithoutDisplayConstraint(
        Tap.SINGLE,
        GeneralLocation.VISIBLE_CENTER,
        Press.FINGER,
        InputDevice.SOURCE_UNKNOWN,
        MotionEvent.BUTTON_PRIMARY);
  }

  private ClickWithoutDisplayConstraint getLongClickAction () {
    return new ClickWithoutDisplayConstraint(
        Tap.LONG,
        GeneralLocation.CENTER,
        Press.FINGER,
        InputDevice.SOURCE_UNKNOWN,
        MotionEvent.BUTTON_PRIMARY);
  }
}
