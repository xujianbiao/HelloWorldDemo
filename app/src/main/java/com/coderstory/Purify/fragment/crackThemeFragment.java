package com.coderstory.Purify.fragment;

import android.view.View;
import android.widget.Switch;

import com.coderstory.Purify.R;

import ren.solid.library.fragment.base.BaseFragment;


public class crackThemeFragment extends BaseFragment {

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_crack_theme;
    }

    @Override
    protected void setUpView() {
        $(R.id.enableCrackTheme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableCrackTheme", ((Switch) v).isChecked());
                setCheck(((Switch) v).isChecked());
            }
        });

        $(R.id.CreakMIUI7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("CreakMIUI7", ((Switch) v).isChecked());
                getEditor().apply();

                ((Switch) $(R.id.CreakMIUI8)).setChecked(!((Switch) v).isChecked());
                getEditor().putBoolean("CreakMIUI8", !((Switch) v).isChecked());
                getEditor().apply();
            }
        });

        $(R.id.CreakMIUI8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("CreakMIUI8", ((Switch) v).isChecked());
                getEditor().apply();

                ((Switch) $(R.id.CreakMIUI7)).setChecked(!((Switch) v).isChecked());
                getEditor().putBoolean("CreakMIUI7", !((Switch) v).isChecked());
                getEditor().apply();
            }
        });


    }

    @Override
    protected void setUpData() {

        ((Switch) $(R.id.enableCrackTheme)).setChecked(getPrefs().getBoolean("enableCrackTheme", false));
        ((Switch) $(R.id.CreakMIUI7)).setChecked(getPrefs().getBoolean("CreakMIUI7", false));
        ((Switch) $(R.id.CreakMIUI8)).setChecked(getPrefs().getBoolean("CreakMIUI8", false));
        setCheck(getPrefs().getBoolean("enableCrackTheme", false));
    }


    private void setCheck(boolean type) {

        if (type) {
            $(R.id.CreakMIUI7).setEnabled(true);
            $(R.id.CreakMIUI8).setEnabled(true);
        } else {
            $(R.id.CreakMIUI7).setEnabled(false);
            $(R.id.CreakMIUI8).setEnabled(false);
        }

    }

}

