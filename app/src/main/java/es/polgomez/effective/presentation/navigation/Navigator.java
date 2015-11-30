package es.polgomez.effective.presentation.navigation;


import android.support.v4.app.FragmentTransaction;

import es.polgomez.effective.presentation.view.fragment.DetailFragment;

public class Navigator {

    public void navigateToPointOfInterestDetail(FragmentTransaction fragmentTransaction,
                                                int pointOfInterestId, int containerViewId) {
        String name = DetailFragment.class.getName();

        fragmentTransaction.replace(containerViewId,
                DetailFragment.newInstance(pointOfInterestId),
                name
        );

        fragmentTransaction.addToBackStack(name);
        fragmentTransaction.commit();
    }
}
