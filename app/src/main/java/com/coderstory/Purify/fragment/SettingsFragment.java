package com.coderstory.Purify.fragment;



import android.view.View;
import android.widget.Switch;

import com.coderstory.Purify.R;

import ren.solid.library.fragment.base.BaseFragment;

import static com.coderstory.Purify.utils.root.ShellUtils.execCommand;


public class SettingsFragment extends BaseFragment {


    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_settings;
    }

    @Override
    protected void setUpView() {


        $(R.id.enableCheck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableCheck",((Switch)v).isChecked());
                getEditor().apply();
            }
        });

        $(R.id.gantanhao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("gantanhao",((Switch)v).isChecked());
                getEditor().apply();

                if (((Switch)v).isChecked()){
                    execCommand("adb shell settings put global captive_portal_server www.g.cn",true);

                }else{
                    execCommand("settings put global captive_portal_detection_enabled 0",true);
                  //  execCommand("adb shell settings put global captive_portal_detection_enabled 1",true);
                }
            }
        });

        $(R.id.enablemiuiRoot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enablemiuiRoot",((Switch)v).isChecked());
                getEditor().apply();
            }
        });

        $(R.id.RemoveSearchBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("RemoveSearchBar",((Switch)v).isChecked());
                getEditor().apply();
            }
        });

    }

    @Override
    protected void setUpData() {
        ((Switch) $(R.id.enableCheck)).setChecked(getPrefs().getBoolean("enableCheck",false));
        ((Switch) $(R.id.gantanhao)).setChecked(getPrefs().getBoolean("gantanhao",false));
        ((Switch) $(R.id.enablemiuiRoot)).setChecked(getPrefs().getBoolean("enablemiuiRoot",false));
        ((Switch) $(R.id.RemoveSearchBar)).setChecked(getPrefs().getBoolean("RemoveSearchBar",false));
    }

}
