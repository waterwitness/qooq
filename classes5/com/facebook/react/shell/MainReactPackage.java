package com.facebook.react.shell;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.location.LocationModule;
import com.facebook.react.modules.netinfo.NetInfoModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.storage.AsyncStorageModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextInlineImageViewManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.views.webview.ReactWebViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainReactPackage
  implements ReactPackage
{
  public List<Class<? extends JavaScriptModule>> createJSModules()
  {
    return Collections.emptyList();
  }
  
  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    return Arrays.asList(new NativeModule[] { new AsyncStorageModule(paramReactApplicationContext), new ClipboardModule(paramReactApplicationContext), new DialogModule(paramReactApplicationContext), new FrescoModule(paramReactApplicationContext), new IntentModule(paramReactApplicationContext), new LocationModule(paramReactApplicationContext), new NetworkingModule(paramReactApplicationContext), new NetInfoModule(paramReactApplicationContext), new WebSocketModule(paramReactApplicationContext), new ToastModule(paramReactApplicationContext) });
  }
  
  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    return Arrays.asList(new ViewManager[] { new ReactHorizontalScrollViewManager(), new ReactImageManager(), new ReactProgressBarViewManager(), new ReactRawTextManager(), new ReactScrollViewManager(), new ReactTextInputManager(), new ReactTextViewManager(), new ReactViewManager(), new ReactTextInlineImageViewManager(), new ReactVirtualTextViewManager(), new ReactWebViewManager() });
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\shell\MainReactPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */