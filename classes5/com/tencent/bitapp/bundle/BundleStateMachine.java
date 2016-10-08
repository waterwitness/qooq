package com.tencent.bitapp.bundle;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.UiThreadUtil;
import com.tencent.bitapp.Const;
import com.tencent.bitapp.manager.BitAppInstanceManager;
import com.tencent.bitapp.module.ModuleCache;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.report.RNReport;
import com.tencent.bitapp.statemachine.ConditionState;
import com.tencent.bitapp.statemachine.IState;
import com.tencent.bitapp.statemachine.LoadState;
import com.tencent.bitapp.statemachine.StateMachine;
import com.tencent.bitapp.thread.ThreadManager;
import com.tencent.bitapp.utils.Md5Utils;
import com.tencent.bitapp.utils.SharedPreferencesUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class BundleStateMachine
  extends StateMachine
{
  private static final String TAG = BundleStateMachine.class.getSimpleName();
  BundleStruct mBundleStruct = null;
  CombinBundle mCombinBundle = null;
  InitState mInitState = null;
  boolean mIsUpdate = false;
  String mKey = null;
  int mLastState = 210;
  LoadFail mLoadFail = null;
  LoadSuccess mLoadSuccess = null;
  LoadingCacheState mLoadingCacheState = null;
  LoadingFileState mLoadingFileState = null;
  LoadingModulesState mLoadingModulesState = null;
  Set<IBundleListener> mSet = null;
  private Bundle tempBundle = null;
  
  BundleStateMachine(String paramString)
  {
    super(paramString);
    setDbg(Const.isDebug);
    this.mSet = new HashSet();
    this.mKey = paramString;
    RNReport.reportStageStart(paramString, 21);
  }
  
  private void loadBundle(final Bundle paramBundle)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "preloadContext");
    }
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (BitAppInstanceManager.getInstance() != null) {
          BitAppInstanceManager.getInstance().loadBundle(paramBundle, null, true);
        }
      }
    });
  }
  
  public void addListener(IBundleListener paramIBundleListener)
  {
    if (FLog.isLoggable(3)) {
      FLog.i(TAG, "addListener listener : " + paramIBundleListener);
    }
    Set localSet = this.mSet;
    if (paramIBundleListener != null) {}
    try
    {
      this.mSet.add(paramIBundleListener);
      return;
    }
    finally {}
  }
  
  public void init()
  {
    this.mInitState = new InitState();
    this.mLoadingCacheState = new LoadingCacheState();
    this.mLoadingFileState = new LoadingFileState();
    this.mLoadingModulesState = new LoadingModulesState();
    this.mCombinBundle = new CombinBundle();
    this.mLoadSuccess = new LoadSuccess();
    this.mLoadFail = new LoadFail();
    addState(this.mInitState);
    addState(this.mLoadingCacheState);
    addState(this.mLoadingFileState);
    addState(this.mLoadingModulesState);
    addState(this.mCombinBundle);
    addState(this.mLoadSuccess);
    addState(this.mLoadFail);
    setInitialState(this.mInitState);
  }
  
  /* Error */
  protected void notifyListeners(String... arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 190	com/tencent/bitapp/bundle/BundleStateMachine:getCurrentState	()Lcom/tencent/bitapp/statemachine/IState;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +752 -> 758
    //   9: aload_0
    //   10: invokevirtual 193	com/tencent/bitapp/bundle/BundleStateMachine:getName	()Ljava/lang/String;
    //   13: astore_2
    //   14: iconst_3
    //   15: invokestatic 131	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   18: ifeq +56 -> 74
    //   21: getstatic 70	com/tencent/bitapp/bundle/BundleStateMachine:TAG	Ljava/lang/String;
    //   24: new 149	java/lang/StringBuilder
    //   27: dup
    //   28: ldc -61
    //   30: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_3
    //   34: invokeinterface 198 1 0
    //   39: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc -53
    //   44: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_0
    //   48: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc -51
    //   53: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   60: invokeinterface 209 1 0
    //   65: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 137	com/facebook/common/logging/FLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_3
    //   75: aload_0
    //   76: getfield 79	com/tencent/bitapp/bundle/BundleStateMachine:mLoadingCacheState	Lcom/tencent/bitapp/bundle/BundleStateMachine$LoadingCacheState;
    //   79: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +55 -> 137
    //   85: aload_0
    //   86: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   89: astore_1
    //   90: aload_1
    //   91: monitorenter
    //   92: aload_0
    //   93: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   96: invokeinterface 221 1 0
    //   101: astore_3
    //   102: aload_3
    //   103: invokeinterface 227 1 0
    //   108: ifne +6 -> 114
    //   111: aload_1
    //   112: monitorexit
    //   113: return
    //   114: aload_3
    //   115: invokeinterface 231 1 0
    //   120: checkcast 233	com/tencent/bitapp/bundle/IBundleListener
    //   123: aload_2
    //   124: invokeinterface 236 2 0
    //   129: goto -27 -> 102
    //   132: astore_2
    //   133: aload_1
    //   134: monitorexit
    //   135: aload_2
    //   136: athrow
    //   137: aload_3
    //   138: aload_0
    //   139: getfield 89	com/tencent/bitapp/bundle/BundleStateMachine:mLoadFail	Lcom/tencent/bitapp/bundle/BundleStateMachine$LoadFail;
    //   142: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   145: ifeq +94 -> 239
    //   148: iconst_1
    //   149: istore 5
    //   151: aload_1
    //   152: iconst_0
    //   153: aaload
    //   154: invokestatic 242	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   157: istore 6
    //   159: iload 6
    //   161: istore 5
    //   163: aload_0
    //   164: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   167: astore_1
    //   168: aload_1
    //   169: monitorenter
    //   170: aload_0
    //   171: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   174: invokeinterface 221 1 0
    //   179: astore_3
    //   180: aload_3
    //   181: invokeinterface 227 1 0
    //   186: ifne +20 -> 206
    //   189: aload_0
    //   190: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   193: invokeinterface 245 1 0
    //   198: aload_1
    //   199: monitorexit
    //   200: aload_0
    //   201: iconst_0
    //   202: putfield 97	com/tencent/bitapp/bundle/BundleStateMachine:mIsUpdate	Z
    //   205: return
    //   206: aload_3
    //   207: invokeinterface 231 1 0
    //   212: checkcast 233	com/tencent/bitapp/bundle/IBundleListener
    //   215: aload_2
    //   216: iload 5
    //   218: invokeinterface 248 3 0
    //   223: goto -43 -> 180
    //   226: astore_2
    //   227: aload_1
    //   228: monitorexit
    //   229: aload_2
    //   230: athrow
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   236: goto -36 -> 200
    //   239: aload_3
    //   240: aload_0
    //   241: getfield 81	com/tencent/bitapp/bundle/BundleStateMachine:mLoadingFileState	Lcom/tencent/bitapp/bundle/BundleStateMachine$LoadingFileState;
    //   244: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   247: ifeq +55 -> 302
    //   250: aload_0
    //   251: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   254: astore_1
    //   255: aload_1
    //   256: monitorenter
    //   257: aload_0
    //   258: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   261: invokeinterface 221 1 0
    //   266: astore_3
    //   267: aload_3
    //   268: invokeinterface 227 1 0
    //   273: ifne +11 -> 284
    //   276: aload_1
    //   277: monitorexit
    //   278: return
    //   279: astore_2
    //   280: aload_1
    //   281: monitorexit
    //   282: aload_2
    //   283: athrow
    //   284: aload_3
    //   285: invokeinterface 231 1 0
    //   290: checkcast 233	com/tencent/bitapp/bundle/IBundleListener
    //   293: aload_2
    //   294: invokeinterface 254 2 0
    //   299: goto -32 -> 267
    //   302: aload_3
    //   303: aload_0
    //   304: getfield 83	com/tencent/bitapp/bundle/BundleStateMachine:mLoadingModulesState	Lcom/tencent/bitapp/bundle/BundleStateMachine$LoadingModulesState;
    //   307: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   310: ifeq +55 -> 365
    //   313: aload_0
    //   314: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   317: astore_1
    //   318: aload_1
    //   319: monitorenter
    //   320: aload_0
    //   321: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   324: invokeinterface 221 1 0
    //   329: astore_3
    //   330: aload_3
    //   331: invokeinterface 227 1 0
    //   336: ifne +11 -> 347
    //   339: aload_1
    //   340: monitorexit
    //   341: return
    //   342: astore_2
    //   343: aload_1
    //   344: monitorexit
    //   345: aload_2
    //   346: athrow
    //   347: aload_3
    //   348: invokeinterface 231 1 0
    //   353: checkcast 233	com/tencent/bitapp/bundle/IBundleListener
    //   356: aload_2
    //   357: invokeinterface 257 2 0
    //   362: goto -32 -> 330
    //   365: aload_3
    //   366: aload_0
    //   367: getfield 85	com/tencent/bitapp/bundle/BundleStateMachine:mCombinBundle	Lcom/tencent/bitapp/bundle/BundleStateMachine$CombinBundle;
    //   370: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   373: ifeq +55 -> 428
    //   376: aload_0
    //   377: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   380: astore_1
    //   381: aload_1
    //   382: monitorenter
    //   383: aload_0
    //   384: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   387: invokeinterface 221 1 0
    //   392: astore_3
    //   393: aload_3
    //   394: invokeinterface 227 1 0
    //   399: ifne +11 -> 410
    //   402: aload_1
    //   403: monitorexit
    //   404: return
    //   405: astore_2
    //   406: aload_1
    //   407: monitorexit
    //   408: aload_2
    //   409: athrow
    //   410: aload_3
    //   411: invokeinterface 231 1 0
    //   416: checkcast 233	com/tencent/bitapp/bundle/IBundleListener
    //   419: aload_2
    //   420: invokeinterface 260 2 0
    //   425: goto -32 -> 393
    //   428: aload_3
    //   429: aload_0
    //   430: getfield 87	com/tencent/bitapp/bundle/BundleStateMachine:mLoadSuccess	Lcom/tencent/bitapp/bundle/BundleStateMachine$LoadSuccess;
    //   433: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   436: ifeq +343 -> 779
    //   439: aload_0
    //   440: getfield 93	com/tencent/bitapp/bundle/BundleStateMachine:tempBundle	Lcom/tencent/bitapp/bundle/Bundle;
    //   443: astore_3
    //   444: aload_3
    //   445: ifnull +211 -> 656
    //   448: aload_0
    //   449: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   452: invokeinterface 209 1 0
    //   457: ifle +173 -> 630
    //   460: aload_3
    //   461: aload_0
    //   462: getfield 97	com/tencent/bitapp/bundle/BundleStateMachine:mIsUpdate	Z
    //   465: invokevirtual 265	com/tencent/bitapp/bundle/Bundle:setForceUpdate	(Z)V
    //   468: aload_0
    //   469: getfield 97	com/tencent/bitapp/bundle/BundleStateMachine:mIsUpdate	Z
    //   472: ifeq +24 -> 496
    //   475: invokestatic 271	com/tencent/bitapp/manager/BitAppInstanceManager:getInstance	()Lcom/tencent/bitapp/manager/BitAppInstanceManager;
    //   478: ifnull +18 -> 496
    //   481: invokestatic 271	com/tencent/bitapp/manager/BitAppInstanceManager:getInstance	()Lcom/tencent/bitapp/manager/BitAppInstanceManager;
    //   484: aload_2
    //   485: invokevirtual 275	com/tencent/bitapp/manager/BitAppInstanceManager:isLoaded	(Ljava/lang/String;)Z
    //   488: ifeq +8 -> 496
    //   491: aload_0
    //   492: aload_3
    //   493: invokespecial 277	com/tencent/bitapp/bundle/BundleStateMachine:loadBundle	(Lcom/tencent/bitapp/bundle/Bundle;)V
    //   496: aload_3
    //   497: iconst_0
    //   498: invokevirtual 265	com/tencent/bitapp/bundle/Bundle:setForceUpdate	(Z)V
    //   501: invokestatic 282	com/tencent/bitapp/bundle/BundleCache:getInstance	()Lcom/tencent/bitapp/bundle/BundleCache;
    //   504: aload_2
    //   505: aload_3
    //   506: invokevirtual 286	com/tencent/bitapp/bundle/BundleCache:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   509: iconst_3
    //   510: invokestatic 131	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   513: ifeq +34 -> 547
    //   516: getstatic 70	com/tencent/bitapp/bundle/BundleStateMachine:TAG	Ljava/lang/String;
    //   519: new 149	java/lang/StringBuilder
    //   522: dup
    //   523: ldc_w 288
    //   526: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   529: aload_0
    //   530: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   533: invokeinterface 209 1 0
    //   538: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 137	com/facebook/common/logging/FLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: aload_0
    //   548: aconst_null
    //   549: putfield 93	com/tencent/bitapp/bundle/BundleStateMachine:tempBundle	Lcom/tencent/bitapp/bundle/Bundle;
    //   552: aload_0
    //   553: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   556: astore_1
    //   557: aload_1
    //   558: monitorenter
    //   559: aload_0
    //   560: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   563: invokeinterface 221 1 0
    //   568: astore 4
    //   570: aload 4
    //   572: invokeinterface 227 1 0
    //   577: ifne +20 -> 597
    //   580: aload_0
    //   581: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   584: invokeinterface 245 1 0
    //   589: aload_1
    //   590: monitorexit
    //   591: aload_0
    //   592: iconst_0
    //   593: putfield 97	com/tencent/bitapp/bundle/BundleStateMachine:mIsUpdate	Z
    //   596: return
    //   597: aload 4
    //   599: invokeinterface 231 1 0
    //   604: checkcast 233	com/tencent/bitapp/bundle/IBundleListener
    //   607: aload_2
    //   608: aload_3
    //   609: invokeinterface 292 3 0
    //   614: goto -44 -> 570
    //   617: astore_2
    //   618: aload_1
    //   619: monitorexit
    //   620: aload_2
    //   621: athrow
    //   622: astore_1
    //   623: aload_1
    //   624: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   627: goto -36 -> 591
    //   630: iconst_3
    //   631: invokestatic 131	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   634: ifeq +12 -> 646
    //   637: getstatic 70	com/tencent/bitapp/bundle/BundleStateMachine:TAG	Ljava/lang/String;
    //   640: ldc_w 294
    //   643: invokestatic 137	com/facebook/common/logging/FLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: invokestatic 282	com/tencent/bitapp/bundle/BundleCache:getInstance	()Lcom/tencent/bitapp/bundle/BundleCache;
    //   649: aload_2
    //   650: invokevirtual 297	com/tencent/bitapp/bundle/BundleCache:remove	(Ljava/lang/String;)V
    //   653: goto -62 -> 591
    //   656: iconst_3
    //   657: invokestatic 131	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   660: ifeq +34 -> 694
    //   663: getstatic 70	com/tencent/bitapp/bundle/BundleStateMachine:TAG	Ljava/lang/String;
    //   666: new 149	java/lang/StringBuilder
    //   669: dup
    //   670: ldc_w 299
    //   673: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   676: aload_0
    //   677: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   680: invokeinterface 209 1 0
    //   685: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   688: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   691: invokestatic 137	com/facebook/common/logging/FLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: aload_0
    //   695: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   698: astore_1
    //   699: aload_1
    //   700: monitorenter
    //   701: aload_0
    //   702: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   705: invokeinterface 221 1 0
    //   710: astore_3
    //   711: aload_3
    //   712: invokeinterface 227 1 0
    //   717: ifne +22 -> 739
    //   720: aload_0
    //   721: getfield 91	com/tencent/bitapp/bundle/BundleStateMachine:mSet	Ljava/util/Set;
    //   724: invokeinterface 245 1 0
    //   729: aload_1
    //   730: monitorexit
    //   731: goto -140 -> 591
    //   734: astore_2
    //   735: aload_1
    //   736: monitorexit
    //   737: aload_2
    //   738: athrow
    //   739: aload_3
    //   740: invokeinterface 231 1 0
    //   745: checkcast 233	com/tencent/bitapp/bundle/IBundleListener
    //   748: aload_2
    //   749: iconst_1
    //   750: invokeinterface 248 3 0
    //   755: goto -44 -> 711
    //   758: iconst_3
    //   759: invokestatic 131	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   762: ifeq +17 -> 779
    //   765: getstatic 70	com/tencent/bitapp/bundle/BundleStateMachine:TAG	Ljava/lang/String;
    //   768: ldc_w 301
    //   771: invokestatic 137	com/facebook/common/logging/FLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   774: return
    //   775: astore_1
    //   776: goto -613 -> 163
    //   779: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	780	0	this	BundleStateMachine
    //   13	111	2	str1	String
    //   132	84	2	str2	String
    //   226	4	2	localObject1	Object
    //   279	15	2	str3	String
    //   342	15	2	str4	String
    //   405	203	2	str5	String
    //   617	33	2	str6	String
    //   734	15	2	str7	String
    //   4	736	3	localObject2	Object
    //   568	30	4	localIterator	java.util.Iterator
    //   149	68	5	i	int
    //   157	3	6	j	int
    // Exception table:
    //   from	to	target	type
    //   92	102	132	finally
    //   102	113	132	finally
    //   114	129	132	finally
    //   133	135	132	finally
    //   170	180	226	finally
    //   180	200	226	finally
    //   206	223	226	finally
    //   227	229	226	finally
    //   163	170	231	java/lang/Exception
    //   229	231	231	java/lang/Exception
    //   257	267	279	finally
    //   267	278	279	finally
    //   280	282	279	finally
    //   284	299	279	finally
    //   320	330	342	finally
    //   330	341	342	finally
    //   343	345	342	finally
    //   347	362	342	finally
    //   383	393	405	finally
    //   393	404	405	finally
    //   406	408	405	finally
    //   410	425	405	finally
    //   559	570	617	finally
    //   570	591	617	finally
    //   597	614	617	finally
    //   618	620	617	finally
    //   439	444	622	java/lang/Exception
    //   448	496	622	java/lang/Exception
    //   496	547	622	java/lang/Exception
    //   547	559	622	java/lang/Exception
    //   620	622	622	java/lang/Exception
    //   630	646	622	java/lang/Exception
    //   646	653	622	java/lang/Exception
    //   656	694	622	java/lang/Exception
    //   694	701	622	java/lang/Exception
    //   737	739	622	java/lang/Exception
    //   701	711	734	finally
    //   711	731	734	finally
    //   735	737	734	finally
    //   739	755	734	finally
    //   151	159	775	java/lang/Exception
  }
  
  public void setBundleStruct(BundleStruct paramBundleStruct)
  {
    this.mBundleStruct = paramBundleStruct;
  }
  
  public void setUpdate(boolean paramBoolean)
  {
    this.mIsUpdate = paramBoolean;
  }
  
  class BundleLoadState
    extends LoadState
  {
    public BundleLoadState()
    {
      super();
    }
    
    public IState getNextState()
    {
      return BundleStateMachine.this.mLoadingCacheState;
    }
    
    protected int loadCache(String paramString)
    {
      if (BundleStateMachine.this.mIsUpdate) {}
      while (!BundleCache.getInstance().isExistInCache(paramString)) {
        return 2;
      }
      return 1;
    }
  }
  
  class CombinBundle
    extends ConditionState
  {
    public CombinBundle()
    {
      super();
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(BundleStateMachine.this.mKey, 21, BundleStateMachine.this.mLastState, 0);
      BundleStateMachine.this.mLastState = 214;
      RNReport.reportStageStepStart(BundleStateMachine.this.mKey, 21, BundleStateMachine.this.mLastState);
      super.enter();
    }
    
    public IState getFailState()
    {
      return BundleStateMachine.this.mLoadFail;
    }
    
    public IState getSuccessState()
    {
      return BundleStateMachine.this.mLoadSuccess;
    }
  }
  
  class InitState
    extends BundleStateMachine.BundleLoadState
  {
    InitState()
    {
      super();
    }
    
    public void enter()
    {
      BundleStateMachine.this.mLastState = 210;
      RNReport.reportStageStepStart(BundleStateMachine.this.mKey, 21, BundleStateMachine.this.mLastState);
      super.enter();
    }
    
    protected int loadCache(String paramString)
    {
      int i = 2;
      int j = super.loadCache(paramString);
      paramString = BundleStateMachine.this.mKey;
      if (BundleStateMachine.this.mIsUpdate) {
        i = 1;
      }
      for (;;)
      {
        RNReport.addStageFlag(paramString, 21, 0, i);
        return j;
        if (j != 2) {
          i = 3;
        }
      }
    }
  }
  
  class LoadFail
    extends BundleStateMachine.BundleLoadState
  {
    LoadFail()
    {
      super();
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(BundleStateMachine.this.mKey, 21, BundleStateMachine.this.mLastState, 6);
      super.enter();
      RNReport.reportStageEnd(BundleStateMachine.this.mKey, 21, 6, BundleStateMachine.this.mLastState);
      RNReport.reportStageStepEnd(BundleStateMachine.this.mKey, 2, 21, 6);
      RNReport.reportStageEnd(BundleStateMachine.this.mKey, 2, 6, 21);
    }
  }
  
  class LoadSuccess
    extends BundleStateMachine.BundleLoadState
  {
    LoadSuccess()
    {
      super();
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(BundleStateMachine.this.mKey, 21, BundleStateMachine.this.mLastState, 0);
      RNReport.reportStageStepStart(BundleStateMachine.this.mKey, 21, 215);
      Context localContext = ContextUtils.INSTANCE.getApplicationContext();
      if (localContext != null)
      {
        String str1 = BundleStateMachine.this.getName();
        String str2 = Bundle.getFile(str1);
        String str3 = Md5Utils.getMd5(new File(str2));
        if (FLog.isLoggable(3)) {
          FLog.i(BundleStateMachine.TAG, "LoadSuccess, key: " + str1 + " | file: " + str2 + " | fileMd5: " + str3);
        }
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3))) {
          if (SharedPreferencesUtils.setMd5(localContext, str2, str3)) {
            BundleStateMachine.this.tempBundle = new Bundle(str1, str2, str3);
          }
        }
      }
      for (;;)
      {
        RNReport.reportStageStepEnd(BundleStateMachine.this.mKey, 21, 215, 0);
        super.enter();
        if (!BundleCache.getInstance().isExistInCache(BundleStateMachine.this.mKey)) {
          break;
        }
        RNReport.reportStageEnd(BundleStateMachine.this.mKey, 21, 0, BundleStateMachine.this.mLastState);
        RNReport.reportStageStepEnd(BundleStateMachine.this.mKey, 2, 21, 0);
        RNReport.reportStageEnd(BundleStateMachine.this.mKey, 2, 0, 21);
        return;
        if (FLog.isLoggable(3))
        {
          FLog.i(BundleStateMachine.TAG, "LoadSuccess set md5 fail");
          continue;
          if (FLog.isLoggable(3))
          {
            FLog.i(BundleStateMachine.TAG, "LoadSuccess key is null or fileMd5 is null");
            continue;
            if (FLog.isLoggable(3)) {
              FLog.i(BundleStateMachine.TAG, "Context is null");
            }
          }
        }
      }
      RNReport.reportStageEnd(BundleStateMachine.this.mKey, 21, 5, BundleStateMachine.this.mLastState);
      RNReport.reportStageStepEnd(BundleStateMachine.this.mKey, 2, 21, 5);
      RNReport.reportStageEnd(BundleStateMachine.this.mKey, 2, 5, 21);
    }
  }
  
  class LoadingCacheState
    extends ConditionState
  {
    public LoadingCacheState()
    {
      super();
    }
    
    protected int doFail(String paramString)
    {
      int k = 2;
      int j;
      int i;
      if (BundleStateMachine.this.mIsUpdate)
      {
        j = 2;
        paramString = BundleStateMachine.this.mKey;
        if (!BundleStateMachine.this.mIsUpdate) {
          break label67;
        }
        i = 1;
      }
      for (;;)
      {
        RNReport.addStageFlag(paramString, 21, 1, i);
        return j;
        if (ModuleCache.getInstance().isExistInFile(paramString)) {}
        for (i = 1;; i = 2)
        {
          j = i;
          break;
        }
        label67:
        i = k;
        if (j != 2) {
          i = 3;
        }
      }
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(BundleStateMachine.this.mKey, 21, BundleStateMachine.this.mLastState, 0);
      BundleStateMachine.this.mLastState = 211;
      RNReport.reportStageStepStart(BundleStateMachine.this.mKey, 21, BundleStateMachine.this.mLastState);
      super.enter();
    }
    
    public IState getFailState()
    {
      return BundleStateMachine.this.mLoadingFileState;
    }
    
    public IState getSuccessState()
    {
      return BundleStateMachine.this.mLoadSuccess;
    }
  }
  
  class LoadingFileState
    extends ConditionState
  {
    public LoadingFileState()
    {
      super();
    }
    
    protected int doFail(String paramString)
    {
      ThreadManager.INSTANCE.execute(new Runnable()
      {
        public void run()
        {
          BundleCache.getInstance().loadModule(BundleStateMachine.this.mBundleStruct, BundleStateMachine.LoadingFileState.this.mStateMachine, BundleStateMachine.this.mIsUpdate);
        }
      });
      return 0;
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(BundleStateMachine.this.mKey, 21, BundleStateMachine.this.mLastState, 6);
      BundleStateMachine.this.mLastState = 212;
      RNReport.reportStageStepStart(BundleStateMachine.this.mKey, 21, BundleStateMachine.this.mLastState);
      super.enter();
    }
    
    public IState getFailState()
    {
      return BundleStateMachine.this.mLoadingModulesState;
    }
    
    public IState getSuccessState()
    {
      return BundleStateMachine.this.mLoadSuccess;
    }
  }
  
  class LoadingModulesState
    extends ConditionState
  {
    public LoadingModulesState()
    {
      super();
    }
    
    protected int doSuccess(String paramString)
    {
      return 1;
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(BundleStateMachine.this.mKey, 21, BundleStateMachine.this.mLastState, 0);
      BundleStateMachine.this.mLastState = 213;
      RNReport.reportStageStepStart(BundleStateMachine.this.mKey, 21, BundleStateMachine.this.mLastState);
      super.enter();
    }
    
    public IState getFailState()
    {
      return BundleStateMachine.this.mLoadFail;
    }
    
    public IState getSuccessState()
    {
      return BundleStateMachine.this.mCombinBundle;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\bundle\BundleStateMachine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */