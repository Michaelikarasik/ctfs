package com.example.foobarhook;

import android.app.Activity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class FoobarHook implements IXposedHookLoadPackage {
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {


        if (!lpparam.packageName.equals("com.kipodafterfree.f00bar"))
            return;

        XposedBridge.log("we are in foobar!");

        findAndHookMethod("a.c.a.a.i", lpparam.classLoader, "a", String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("michael got license: " + param.args[0]);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("michael got i result: " + param.getResult());
            }
        });

        findAndHookMethod("a.c.a.a.f", lpparam.classLoader, "a", String.class, "a.c.a.a.f$b[]", "a.c.a.a.f$a", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("michael f request string: " + param.args[0]);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            }
        });

        findAndHookMethod("c.B$b", lpparam.classLoader, "a", String.class, String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("request url: " + (String) param.args[1]);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            }
        });

        /*findAndHookMethod("b.d.b.h", lpparam.classLoader, "a", Object.class, String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                try {
                    XposedBridge.log("object string: " + param.args[0]);
                }catch(Exception e){
                }
                XposedBridge.log("object desc: " + param.args[1]);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            }
        });*/

        findAndHookMethod("a.c.a.a.c", lpparam.classLoader, "a", "c.e", "c.I", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("michael response got: " + param.args[1].toString());
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            }
        });

        findAndHookMethod("a.c.a.b.h", lpparam.classLoader, "a", String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("hooked the ok function");
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            }
        });

        findAndHookMethod("android.webkit.WebView", lpparam.classLoader, "loadDataWithBaseURL", String.class, String.class, String.class, String.class, String.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("hooked webview!");
                XposedBridge.log("load data data: " + param.args[1]);
                ((WebView)param.thisObject).setWebViewClient(new WebViewClient(){
                    public void onPageFinished(WebView view, String url) {
                        XposedBridge.log("web client url: " + url);
                        XposedBridge.log("tried to make it print its own html");
                        view.loadUrl("javascript:window.HTMLOUT.processHTML('<head>'+document.getElementsByTagName('html')[0].innerHTML+'</head>');");
                    }

                    public boolean shouldOverrideUrlLoading(WebView arg1, WebResourceRequest arg2) {
                        return true;
                    }
                });
                XposedBridge.log("original url: " + ((WebView) param.thisObject).getOriginalUrl());
                XposedBridge.log("current url: " + ((WebView) param.thisObject).getUrl());
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            }
        });
    }
}
