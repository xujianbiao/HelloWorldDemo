package com.coderstory.Purify.fragment;

import android.view.View;
import android.widget.Switch;

import com.coderstory.Purify.R;

import ren.solid.library.fragment.base.BaseFragment;

import static com.coderstory.Purify.utils.root.ShellUtils.execCommand;
import static com.coderstory.Purify.utils.root.SuHelper.canRunRootCommands;


public class BlockADSFragment extends BaseFragment {

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_block_ad;
    }


    @Override
    protected void setUpView() {
        $(R.id.enableBlockAD).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableBlockAD", ((Switch) v).isChecked());
                getEditor().apply();
                setCheck(((Switch) v).isChecked());


                ((Switch)  $(R.id.enableBlockADBasic)).setChecked(((Switch) v).isChecked());
                getEditor().putBoolean("enableBlockADBasic", ((Switch) v).isChecked());
                getEditor().apply();

                if (((Switch) v).isChecked()){

                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            execCommand("pm disable com.miui.systemAdSolution",true);
                            execCommand("pm disable com.miui.analytics",true);
                            execCommand("pm disable com.qualcomm.qti.seemp.service",true);
                        }
                    }.start();


                }else{

                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            execCommand("pm enable com.miui.systemAdSolution",true);
                            execCommand("pm enable com.miui.analytics",true);
                            execCommand("pm enable com.qualcomm.qti.seemp.service",true);
                        }
                    }.start();

                }


            }
        });

        $(R.id.enableBlockADBasic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableBlockADBasic", ((Switch) v).isChecked());
                getEditor().apply();
            }
        });

        $(R.id.enableMMS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableMMS", ((Switch) v).isChecked());
                getEditor().apply();
            }
        });
        $(R.id.enableWeather).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableWeather", ((Switch) v).isChecked());
                getEditor().apply();
            }
        });
        $(R.id.enableFileManager).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableFileManager", ((Switch) v).isChecked());
                getEditor().apply();
            }
        });

        $(R.id.enableDownload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableDownload", ((Switch) v).isChecked());
                getEditor().apply();
            }
        });

        $(R.id.enableCalendar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableCalendar", ((Switch) v).isChecked());
                getEditor().apply();
            }
        });

        $(R.id.enableSafeCenter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableSafeCenter", ((Switch) v).isChecked());
                getEditor().apply();
            }
        });

        $(R.id.enableHotKey).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableHotKey", ((Switch) v).isChecked());
                getEditor().apply();
            }
        });

        $(R.id.enableMusic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditor().putBoolean("enableMusic", ((Switch) v).isChecked());
                getEditor().apply();
            }
        });

    }

    @Override
    protected void setUpData() {

        ((Switch) $(R.id.enableBlockAD)).setChecked(getPrefs().getBoolean("enableBlockAD", false));
        ((Switch) $(R.id.enableBlockADBasic)).setChecked(getPrefs().getBoolean("enableBlockADBasic", false));
        ((Switch) $(R.id.enableMMS)).setChecked(getPrefs().getBoolean("enableMMS", false));
        ((Switch) $(R.id.enableWeather)).setChecked(getPrefs().getBoolean("enableWeather", false));
        ((Switch) $(R.id.enableFileManager)).setChecked(getPrefs().getBoolean("enableFileManager", false));
        ((Switch) $(R.id.enableDownload)).setChecked(getPrefs().getBoolean("enableDownload", false));
        ((Switch) $(R.id.enableCalendar)).setChecked(getPrefs().getBoolean("enableCalendar", false));
        ((Switch) $(R.id.enableHotKey)).setChecked(getPrefs().getBoolean("enableHotKey", false));
        ((Switch) $(R.id.enableSafeCenter)).setChecked(getPrefs().getBoolean("enableSafeCenter", false));
        ((Switch) $(R.id.enableMusic)).setChecked(getPrefs().getBoolean("enableMusic", false));
        setCheck(getPrefs().getBoolean("enableBlockAD", false));
    }

    private void setCheck(boolean type) {

        if (type) {
            $(R.id.enableBlockADBasic).setEnabled(true);
            $(R.id.enableMMS).setEnabled(true);
            $(R.id.enableWeather).setEnabled(true);
            $(R.id.enableFileManager).setEnabled(true);
            $(R.id.enableDownload).setEnabled(true);
            $(R.id.enableCalendar).setEnabled(true);
            $(R.id.enableHotKey).setEnabled(true);
            $(R.id.enableSafeCenter).setEnabled(true);
            $(R.id.enableMusic).setEnabled(true);
        } else {
            $(R.id.enableBlockADBasic).setEnabled(false);
            $(R.id.enableMMS).setEnabled(false);
            $(R.id.enableWeather).setEnabled(false);
            $(R.id.enableFileManager).setEnabled(false);
            $(R.id.enableDownload).setEnabled(false);
            $(R.id.enableCalendar).setEnabled(false);
            $(R.id.enableHotKey).setEnabled(false);
            $(R.id.enableSafeCenter).setEnabled(false);
            $(R.id.enableMusic).setEnabled(false);
        }

    }

}
