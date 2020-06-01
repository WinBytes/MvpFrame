package com.rain.mvpframe.base;

import android.app.Application;
import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;
import com.rain.mvpframe.core.DataManager;
import com.rain.mvpframe.di.component.DaggerAppComponent;
import com.rain.mvpframe.module.AppModule;
import com.rain.mvpframe.module.HttpModule;
import javax.inject.Inject;

/**
 * author ：rain
 * date : 2020/6/1 11:58
 * package：com.rain.mvpframe.base
 * description :
 */
public class GlobalApplication extends Application {
    private static Context context;
//    private RefWatcher refWatcher;
    @Inject
    public DataManager mDataManager;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule())
                .build().inject(this);

        if (mDataManager.isNightMode()) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }

//        refWatcher = setupLeakCanary();

    }

//    private RefWatcher setupLeakCanary() {
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return RefWatcher.DISABLED;
//        }
//        return LeakCanary.install(this);
//    }
//
//    public static RefWatcher getRefWatcher(Context context) {
//        GlobalApplication application = (GlobalApplication) context.getApplicationContext();
//        return application.refWatcher;
//    }

    public static Context getContext() {
        return context;
    }

    public static boolean isNightMode() {
        GlobalApplication application = (GlobalApplication) context.getApplicationContext();
        return application.mDataManager.isNightMode();
    }

}
