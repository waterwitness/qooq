package com.facebook.stetho.inspector.domstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.DomStorageItemAddedParams;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.DomStorageItemRemovedParams;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.DomStorageItemUpdatedParams;
import com.facebook.stetho.inspector.protocol.module.DOMStorage.StorageId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DOMStoragePeerManager
  extends ChromePeerManager
{
  private final Context mContext;
  private final PeerRegistrationListener mPeerListener = new PeersRegisteredListener()
  {
    private final List<DOMStoragePeerManager.DevToolsSharedPreferencesListener> mPrefsListeners = new ArrayList();
    
    /* Error */
    protected void onFirstPeerRegistered()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 15	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$1:this$0	Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;
      //   6: invokestatic 29	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager:access$0	(Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;)Landroid/content/Context;
      //   9: invokestatic 35	com/facebook/stetho/inspector/domstorage/SharedPreferencesHelper:getSharedPreferenceTags	(Landroid/content/Context;)Ljava/util/List;
      //   12: invokeinterface 41 1 0
      //   17: astore_1
      //   18: aload_1
      //   19: invokeinterface 47 1 0
      //   24: istore 4
      //   26: iload 4
      //   28: ifne +6 -> 34
      //   31: aload_0
      //   32: monitorexit
      //   33: return
      //   34: aload_1
      //   35: invokeinterface 51 1 0
      //   40: checkcast 53	java/lang/String
      //   43: astore_3
      //   44: aload_0
      //   45: getfield 15	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$1:this$0	Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;
      //   48: invokestatic 29	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager:access$0	(Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;)Landroid/content/Context;
      //   51: aload_3
      //   52: iconst_0
      //   53: invokevirtual 59	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   56: astore_2
      //   57: new 61	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$DevToolsSharedPreferencesListener
      //   60: dup
      //   61: aload_0
      //   62: getfield 15	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$1:this$0	Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;
      //   65: aload_2
      //   66: aload_3
      //   67: invokespecial 64	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$DevToolsSharedPreferencesListener:<init>	(Lcom/facebook/stetho/inspector/domstorage/DOMStoragePeerManager;Landroid/content/SharedPreferences;Ljava/lang/String;)V
      //   70: astore_3
      //   71: aload_2
      //   72: aload_3
      //   73: invokeinterface 70 2 0
      //   78: aload_0
      //   79: getfield 23	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$1:mPrefsListeners	Ljava/util/List;
      //   82: aload_3
      //   83: invokeinterface 74 2 0
      //   88: pop
      //   89: goto -71 -> 18
      //   92: astore_1
      //   93: aload_0
      //   94: monitorexit
      //   95: aload_1
      //   96: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	97	0	this	1
      //   17	18	1	localIterator	Iterator
      //   92	4	1	localObject1	Object
      //   56	16	2	localSharedPreferences	SharedPreferences
      //   43	40	3	localObject2	Object
      //   24	3	4	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	18	92	finally
      //   18	26	92	finally
      //   34	89	92	finally
    }
    
    /* Error */
    protected void onLastPeerUnregistered()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 23	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$1:mPrefsListeners	Ljava/util/List;
      //   6: invokeinterface 41 1 0
      //   11: astore_1
      //   12: aload_1
      //   13: invokeinterface 47 1 0
      //   18: ifne +15 -> 33
      //   21: aload_0
      //   22: getfield 23	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$1:mPrefsListeners	Ljava/util/List;
      //   25: invokeinterface 78 1 0
      //   30: aload_0
      //   31: monitorexit
      //   32: return
      //   33: aload_1
      //   34: invokeinterface 51 1 0
      //   39: checkcast 61	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$DevToolsSharedPreferencesListener
      //   42: invokevirtual 81	com/facebook/stetho/inspector/domstorage/DOMStoragePeerManager$DevToolsSharedPreferencesListener:unregister	()V
      //   45: goto -33 -> 12
      //   48: astore_1
      //   49: aload_0
      //   50: monitorexit
      //   51: aload_1
      //   52: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	53	0	this	1
      //   11	23	1	localIterator	Iterator
      //   48	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	12	48	finally
      //   12	30	48	finally
      //   33	45	48	finally
    }
  };
  
  public DOMStoragePeerManager(Context paramContext)
  {
    this.mContext = paramContext;
    setListener(this.mPeerListener);
  }
  
  private static Map<String, Object> prefsCopy(Map<String, ?> paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext()) {
        return localHashMap;
      }
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof Set)) {
        localHashMap.put(str, shallowCopy((Set)localObject));
      } else {
        localHashMap.put(str, localObject);
      }
    }
  }
  
  private static <T> Set<T> shallowCopy(Set<T> paramSet)
  {
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    for (;;)
    {
      if (!paramSet.hasNext()) {
        return localHashSet;
      }
      localHashSet.add((Object)paramSet.next());
    }
  }
  
  public void signalItemAdded(DOMStorage.StorageId paramStorageId, String paramString1, String paramString2)
  {
    DOMStorage.DomStorageItemAddedParams localDomStorageItemAddedParams = new DOMStorage.DomStorageItemAddedParams();
    localDomStorageItemAddedParams.storageId = paramStorageId;
    localDomStorageItemAddedParams.key = paramString1;
    localDomStorageItemAddedParams.newValue = paramString2;
    sendNotificationToPeers("DOMStorage.domStorageItemAdded", localDomStorageItemAddedParams);
  }
  
  public void signalItemRemoved(DOMStorage.StorageId paramStorageId, String paramString)
  {
    DOMStorage.DomStorageItemRemovedParams localDomStorageItemRemovedParams = new DOMStorage.DomStorageItemRemovedParams();
    localDomStorageItemRemovedParams.storageId = paramStorageId;
    localDomStorageItemRemovedParams.key = paramString;
    sendNotificationToPeers("DOMStorage.domStorageItemRemoved", localDomStorageItemRemovedParams);
  }
  
  public void signalItemUpdated(DOMStorage.StorageId paramStorageId, String paramString1, String paramString2, String paramString3)
  {
    DOMStorage.DomStorageItemUpdatedParams localDomStorageItemUpdatedParams = new DOMStorage.DomStorageItemUpdatedParams();
    localDomStorageItemUpdatedParams.storageId = paramStorageId;
    localDomStorageItemUpdatedParams.key = paramString1;
    localDomStorageItemUpdatedParams.oldValue = paramString2;
    localDomStorageItemUpdatedParams.newValue = paramString3;
    sendNotificationToPeers("DOMStorage.domStorageItemUpdated", localDomStorageItemUpdatedParams);
  }
  
  private class DevToolsSharedPreferencesListener
    implements SharedPreferences.OnSharedPreferenceChangeListener
  {
    private final Map<String, Object> mCopy;
    private final SharedPreferences mPrefs;
    private final DOMStorage.StorageId mStorageId;
    
    public DevToolsSharedPreferencesListener(SharedPreferences paramSharedPreferences, String paramString)
    {
      this.mPrefs = paramSharedPreferences;
      this.mStorageId = new DOMStorage.StorageId();
      this.mStorageId.securityOrigin = paramString;
      this.mStorageId.isLocalStorage = true;
      this.mCopy = DOMStoragePeerManager.prefsCopy(paramSharedPreferences.getAll());
    }
    
    public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
    {
      paramSharedPreferences = paramSharedPreferences.getAll();
      boolean bool1 = this.mCopy.containsKey(paramString);
      boolean bool2 = paramSharedPreferences.containsKey(paramString);
      if (bool2) {}
      for (paramSharedPreferences = paramSharedPreferences.get(paramString); (bool1) && (bool2); paramSharedPreferences = null)
      {
        DOMStoragePeerManager.this.signalItemUpdated(this.mStorageId, paramString, SharedPreferencesHelper.valueToString(this.mCopy.get(paramString)), SharedPreferencesHelper.valueToString(paramSharedPreferences));
        this.mCopy.put(paramString, paramSharedPreferences);
        return;
      }
      if (bool1)
      {
        DOMStoragePeerManager.this.signalItemRemoved(this.mStorageId, paramString);
        this.mCopy.remove(paramString);
        return;
      }
      if (bool2)
      {
        DOMStoragePeerManager.this.signalItemAdded(this.mStorageId, paramString, SharedPreferencesHelper.valueToString(paramSharedPreferences));
        this.mCopy.put(paramString, paramSharedPreferences);
        return;
      }
      LogUtil.i("Detected rapid put/remove of %s", new Object[] { paramString });
    }
    
    public void unregister()
    {
      this.mPrefs.unregisterOnSharedPreferenceChangeListener(this);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\domstorage\DOMStoragePeerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */