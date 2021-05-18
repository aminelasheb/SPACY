package com.example.spacy;//package com.example.spacysprint1;
//
//
//import android.view.View;
//import android.widget.FrameLayout;
//
//import androidx.coordinatorlayout.widget.CoordinatorLayout;
//import androidx.core.view.ViewCompat;
//
//import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
//
//
//
//public class ScrollHandler extends CoordinatorLayout.Behavior<MeowBottomNavigation> {
//    @Override
//    public boolean layoutDependsOn(CoordinatorLayout parent, MeowBottomNavigation child, View dependency) {
//        return dependency instanceof FrameLayout;
//
//    }
//
//    @Override
//    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, MeowBottomNavigation child,
//                                       View directTargetChild, View target, int nestedScrollAxes) {
//        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
//    }
//
//    @Override
//    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, MeowBottomNavigation child,
//                                  View target, int dx, int dy, int[] consumed) {
//        if (dy < 0) {
//            showBottomNavigationView(child);
//        } else if (dy > 0) {
//            hideBottomNavigationView(child);
//        }
//    }
//
//    private void hideBottomNavigationView(MeowBottomNavigation view) {
//        view.animate().translationY(view.getHeight());
//    }
//
//    private void showBottomNavigationView(MeowBottomNavigation view) {
//        view.animate().translationY(0);
//    }
//}
