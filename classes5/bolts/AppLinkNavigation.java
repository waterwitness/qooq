package bolts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.util.SparseArray;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLinkNavigation
{
  private static final String KEY_NAME_REFERER_APP_LINK = "referer_app_link";
  private static final String KEY_NAME_REFERER_APP_LINK_APP_NAME = "app_name";
  private static final String KEY_NAME_REFERER_APP_LINK_PACKAGE = "package";
  private static final String KEY_NAME_USER_AGENT = "user_agent";
  private static final String KEY_NAME_VERSION = "version";
  private static final String VERSION = "1.0";
  private static AppLinkResolver defaultResolver;
  private final AppLink appLink;
  private final Bundle appLinkData;
  private final Bundle extras;
  
  public AppLinkNavigation(AppLink paramAppLink, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramAppLink == null) {
      throw new IllegalArgumentException("appLink must not be null.");
    }
    Bundle localBundle = paramBundle1;
    if (paramBundle1 == null) {
      localBundle = new Bundle();
    }
    paramBundle1 = paramBundle2;
    if (paramBundle2 == null) {
      paramBundle1 = new Bundle();
    }
    this.appLink = paramAppLink;
    this.extras = localBundle;
    this.appLinkData = paramBundle1;
  }
  
  private Bundle buildAppLinkDataForNavigation(Context paramContext)
  {
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = new Bundle();
    if (paramContext != null)
    {
      Object localObject = paramContext.getPackageName();
      if (localObject != null) {
        localBundle2.putString("package", (String)localObject);
      }
      localObject = paramContext.getApplicationInfo();
      if (localObject != null)
      {
        paramContext = paramContext.getString(((ApplicationInfo)localObject).labelRes);
        if (paramContext != null) {
          localBundle2.putString("app_name", paramContext);
        }
      }
    }
    localBundle1.putAll(getAppLinkData());
    localBundle1.putString("target_url", getAppLink().getSourceUrl().toString());
    localBundle1.putString("version", "1.0");
    localBundle1.putString("user_agent", "Bolts Android 1.1.4");
    localBundle1.putBundle("referer_app_link", localBundle2);
    localBundle1.putBundle("extras", getExtras());
    return localBundle1;
  }
  
  public static AppLinkResolver getDefaultResolver()
  {
    return defaultResolver;
  }
  
  private JSONObject getJSONForBundle(Bundle paramBundle)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localJSONObject;
      }
      String str = (String)localIterator.next();
      localJSONObject.put(str, getJSONValue(paramBundle.get(str)));
    }
  }
  
  private Object getJSONValue(Object paramObject)
    throws JSONException
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i = 0;
    if ((paramObject instanceof Bundle))
    {
      paramObject = getJSONForBundle((Bundle)paramObject);
      return paramObject;
    }
    if ((paramObject instanceof CharSequence)) {
      return paramObject.toString();
    }
    JSONArray localJSONArray;
    Object localObject;
    if ((paramObject instanceof List))
    {
      localJSONArray = new JSONArray();
      localObject = ((List)paramObject).iterator();
      for (;;)
      {
        paramObject = localJSONArray;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localJSONArray.put(getJSONValue(((Iterator)localObject).next()));
      }
    }
    if ((paramObject instanceof SparseArray))
    {
      localJSONArray = new JSONArray();
      localObject = (SparseArray)paramObject;
      i = 0;
      for (;;)
      {
        paramObject = localJSONArray;
        if (i >= ((SparseArray)localObject).size()) {
          break;
        }
        localJSONArray.put(((SparseArray)localObject).keyAt(i), getJSONValue(((SparseArray)localObject).valueAt(i)));
        i += 1;
      }
    }
    if ((paramObject instanceof Character)) {
      return paramObject.toString();
    }
    if ((paramObject instanceof Boolean)) {
      return paramObject;
    }
    if ((paramObject instanceof Number))
    {
      if (((paramObject instanceof Double)) || ((paramObject instanceof Float))) {
        return Double.valueOf(((Number)paramObject).doubleValue());
      }
      return Long.valueOf(((Number)paramObject).longValue());
    }
    if ((paramObject instanceof boolean[]))
    {
      localJSONArray = new JSONArray();
      localObject = (boolean[])paramObject;
      j = localObject.length;
      for (;;)
      {
        paramObject = localJSONArray;
        if (i >= j) {
          break;
        }
        localJSONArray.put(getJSONValue(Boolean.valueOf(localObject[i])));
        i += 1;
      }
    }
    if ((paramObject instanceof char[]))
    {
      localJSONArray = new JSONArray();
      localObject = (char[])paramObject;
      k = localObject.length;
      i = j;
      for (;;)
      {
        paramObject = localJSONArray;
        if (i >= k) {
          break;
        }
        localJSONArray.put(getJSONValue(Character.valueOf(localObject[i])));
        i += 1;
      }
    }
    if ((paramObject instanceof CharSequence[]))
    {
      localJSONArray = new JSONArray();
      localObject = (CharSequence[])paramObject;
      j = localObject.length;
      i = k;
      for (;;)
      {
        paramObject = localJSONArray;
        if (i >= j) {
          break;
        }
        localJSONArray.put(getJSONValue(localObject[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof double[]))
    {
      localJSONArray = new JSONArray();
      localObject = (double[])paramObject;
      j = localObject.length;
      i = m;
      for (;;)
      {
        paramObject = localJSONArray;
        if (i >= j) {
          break;
        }
        localJSONArray.put(getJSONValue(Double.valueOf(localObject[i])));
        i += 1;
      }
    }
    if ((paramObject instanceof float[]))
    {
      localJSONArray = new JSONArray();
      localObject = (float[])paramObject;
      j = localObject.length;
      i = n;
      for (;;)
      {
        paramObject = localJSONArray;
        if (i >= j) {
          break;
        }
        localJSONArray.put(getJSONValue(Float.valueOf(localObject[i])));
        i += 1;
      }
    }
    if ((paramObject instanceof int[]))
    {
      localJSONArray = new JSONArray();
      localObject = (int[])paramObject;
      j = localObject.length;
      i = i1;
      for (;;)
      {
        paramObject = localJSONArray;
        if (i >= j) {
          break;
        }
        localJSONArray.put(getJSONValue(Integer.valueOf(localObject[i])));
        i += 1;
      }
    }
    if ((paramObject instanceof long[]))
    {
      localJSONArray = new JSONArray();
      localObject = (long[])paramObject;
      j = localObject.length;
      i = i2;
      for (;;)
      {
        paramObject = localJSONArray;
        if (i >= j) {
          break;
        }
        localJSONArray.put(getJSONValue(Long.valueOf(localObject[i])));
        i += 1;
      }
    }
    if ((paramObject instanceof short[]))
    {
      localJSONArray = new JSONArray();
      localObject = (short[])paramObject;
      j = localObject.length;
      i = i3;
      for (;;)
      {
        paramObject = localJSONArray;
        if (i >= j) {
          break;
        }
        localJSONArray.put(getJSONValue(Short.valueOf(localObject[i])));
        i += 1;
      }
    }
    if ((paramObject instanceof String[]))
    {
      localJSONArray = new JSONArray();
      localObject = (String[])paramObject;
      j = localObject.length;
      i = i4;
      for (;;)
      {
        paramObject = localJSONArray;
        if (i >= j) {
          break;
        }
        localJSONArray.put(getJSONValue(localObject[i]));
        i += 1;
      }
    }
    return null;
  }
  
  private static AppLinkResolver getResolver(Context paramContext)
  {
    if (getDefaultResolver() != null) {
      return getDefaultResolver();
    }
    return new WebViewAppLinkResolver(paramContext);
  }
  
  public static NavigationResult navigate(Context paramContext, AppLink paramAppLink)
  {
    return new AppLinkNavigation(paramAppLink, null, null).navigate(paramContext);
  }
  
  public static Task<NavigationResult> navigateInBackground(Context paramContext, Uri paramUri)
  {
    return navigateInBackground(paramContext, paramUri, getResolver(paramContext));
  }
  
  public static Task<NavigationResult> navigateInBackground(Context paramContext, Uri paramUri, AppLinkResolver paramAppLinkResolver)
  {
    paramAppLinkResolver.getAppLinkFromUrlInBackground(paramUri).onSuccess(new Continuation()
    {
      public AppLinkNavigation.NavigationResult then(Task<AppLink> paramAnonymousTask)
        throws Exception
      {
        return AppLinkNavigation.navigate(AppLinkNavigation.this, (AppLink)paramAnonymousTask.getResult());
      }
    }, Task.UI_THREAD_EXECUTOR);
  }
  
  public static Task<NavigationResult> navigateInBackground(Context paramContext, String paramString)
  {
    return navigateInBackground(paramContext, paramString, getResolver(paramContext));
  }
  
  public static Task<NavigationResult> navigateInBackground(Context paramContext, String paramString, AppLinkResolver paramAppLinkResolver)
  {
    return navigateInBackground(paramContext, Uri.parse(paramString), paramAppLinkResolver);
  }
  
  public static Task<NavigationResult> navigateInBackground(Context paramContext, URL paramURL)
  {
    return navigateInBackground(paramContext, paramURL, getResolver(paramContext));
  }
  
  public static Task<NavigationResult> navigateInBackground(Context paramContext, URL paramURL, AppLinkResolver paramAppLinkResolver)
  {
    return navigateInBackground(paramContext, Uri.parse(paramURL.toString()), paramAppLinkResolver);
  }
  
  private void sendAppLinkNavigateEventBroadcast(Context paramContext, Intent paramIntent, NavigationResult paramNavigationResult, JSONException paramJSONException)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONException != null) {
      localHashMap.put("error", paramJSONException.getLocalizedMessage());
    }
    if (paramNavigationResult.isSucceeded()) {}
    for (paramJSONException = "1";; paramJSONException = "0")
    {
      localHashMap.put("success", paramJSONException);
      localHashMap.put("type", paramNavigationResult.getCode());
      MeasurementEvent.sendBroadcastEvent(paramContext, "al_nav_out", paramIntent, localHashMap);
      return;
    }
  }
  
  public static void setDefaultResolver(AppLinkResolver paramAppLinkResolver)
  {
    defaultResolver = paramAppLinkResolver;
  }
  
  public AppLink getAppLink()
  {
    return this.appLink;
  }
  
  public Bundle getAppLinkData()
  {
    return this.appLinkData;
  }
  
  public Bundle getExtras()
  {
    return this.extras;
  }
  
  public NavigationResult navigate(Context paramContext)
  {
    Object localObject3 = paramContext.getPackageManager();
    Bundle localBundle = buildAppLinkDataForNavigation(paramContext);
    Object localObject1 = null;
    Object localObject4 = getAppLink().getTargets().iterator();
    label39:
    Object localObject2;
    if (!((Iterator)localObject4).hasNext())
    {
      localObject2 = null;
      localObject3 = NavigationResult.FAILED;
      if (localObject1 == null) {
        break label194;
      }
      localObject3 = NavigationResult.APP;
      localObject2 = localObject1;
    }
    for (;;)
    {
      sendAppLinkNavigateEventBroadcast(paramContext, (Intent)localObject2, (NavigationResult)localObject3, null);
      if (localObject2 != null) {
        paramContext.startActivity((Intent)localObject2);
      }
      return (NavigationResult)localObject3;
      AppLink.Target localTarget = (AppLink.Target)((Iterator)localObject4).next();
      localObject2 = new Intent("android.intent.action.VIEW");
      if (localTarget.getUrl() != null) {
        ((Intent)localObject2).setData(localTarget.getUrl());
      }
      for (;;)
      {
        ((Intent)localObject2).setPackage(localTarget.getPackageName());
        if (localTarget.getClassName() != null) {
          ((Intent)localObject2).setClassName(localTarget.getPackageName(), localTarget.getClassName());
        }
        ((Intent)localObject2).putExtra("al_applink_data", localBundle);
        if (((PackageManager)localObject3).resolveActivity((Intent)localObject2, 65536) == null) {
          break;
        }
        localObject1 = localObject2;
        break label39;
        ((Intent)localObject2).setData(this.appLink.getSourceUrl());
      }
      label194:
      localObject4 = getAppLink().getWebUrl();
      if (localObject4 == null) {
        continue;
      }
      try
      {
        localObject2 = getJSONForBundle(localBundle);
        localObject2 = new Intent("android.intent.action.VIEW", ((Uri)localObject4).buildUpon().appendQueryParameter("al_applink_data", ((JSONObject)localObject2).toString()).build());
        localObject3 = NavigationResult.WEB;
      }
      catch (JSONException localJSONException)
      {
        sendAppLinkNavigateEventBroadcast(paramContext, (Intent)localObject1, NavigationResult.FAILED, localJSONException);
        throw new RuntimeException(localJSONException);
      }
    }
  }
  
  public static enum NavigationResult
  {
    FAILED("failed", false),  WEB("web", true),  APP("app", true);
    
    private String code;
    private boolean succeeded;
    
    private NavigationResult(String paramString1, boolean paramBoolean)
    {
      this.code = paramString1;
      this.succeeded = paramBoolean;
    }
    
    public String getCode()
    {
      return this.code;
    }
    
    public boolean isSucceeded()
    {
      return this.succeeded;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\bolts\AppLinkNavigation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */