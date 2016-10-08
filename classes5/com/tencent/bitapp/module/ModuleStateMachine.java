package com.tencent.bitapp.module;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.tencent.bitapp.Const;
import com.tencent.bitapp.bundle.Bundle;
import com.tencent.bitapp.bundle.BundleStruct;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.report.RNReport;
import com.tencent.bitapp.statemachine.ConditionState;
import com.tencent.bitapp.statemachine.IState;
import com.tencent.bitapp.statemachine.LoadState;
import com.tencent.bitapp.statemachine.StateMachine;
import com.tencent.bitapp.utils.Md5Utils;
import com.tencent.bitapp.utils.SharedPreferencesUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ModuleStateMachine
  extends StateMachine
{
  private static final String TAG = ModuleStateMachine.class.getSimpleName();
  BundleStruct mBundleStruct = null;
  InitState mInitState = null;
  boolean mIsUpdate = false;
  String mKey = null;
  int mLastState = 0;
  LoadFail mLoadFail = null;
  LoadSuccess mLoadSuccess = null;
  LoadingCacheState mLoadingCacheState = null;
  LoadingDependencies mLoadingDependencies = null;
  LoadingDependenciesFileState mLoadingDependenciesFileState = null;
  LoadingDetailState mLoadingDetailState = null;
  LoadingFileState mLoadingFileState = null;
  LoadingNetState mLoadingNetState = null;
  LoadingUnZipState mLoadingUnZipState = null;
  Set<IModuleListener> mSet = null;
  
  ModuleStateMachine(String paramString)
  {
    super(paramString);
    setDbg(Const.isDebug);
    this.mSet = new HashSet();
    this.mKey = paramString;
    this.mLastState = 220;
    RNReport.reportStageStart(paramString, 22);
  }
  
  public void addListener(IModuleListener paramIModuleListener)
  {
    synchronized (this.mSet)
    {
      this.mSet.add(paramIModuleListener);
      return;
    }
  }
  
  public void init()
  {
    this.mInitState = new InitState();
    this.mLoadingCacheState = new LoadingCacheState();
    this.mLoadingDependenciesFileState = new LoadingDependenciesFileState();
    this.mLoadingFileState = new LoadingFileState();
    this.mLoadingDetailState = new LoadingDetailState();
    this.mLoadingNetState = new LoadingNetState();
    this.mLoadingUnZipState = new LoadingUnZipState();
    this.mLoadSuccess = new LoadSuccess();
    this.mLoadFail = new LoadFail();
    this.mLoadingDependencies = new LoadingDependencies();
    addState(this.mInitState);
    addState(this.mLoadingCacheState);
    addState(this.mLoadingDependenciesFileState);
    addState(this.mLoadingFileState);
    addState(this.mLoadingDetailState);
    addState(this.mLoadingNetState);
    addState(this.mLoadingUnZipState);
    addState(this.mLoadSuccess);
    addState(this.mLoadFail);
    addState(this.mLoadingDependencies);
    setInitialState(this.mInitState);
  }
  
  /* Error */
  protected void notifyListeners(String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 170	com/tencent/bitapp/module/ModuleStateMachine:getCurrentState	()Lcom/tencent/bitapp/statemachine/IState;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnull +635 -> 641
    //   9: aload_0
    //   10: invokevirtual 173	com/tencent/bitapp/module/ModuleStateMachine:getName	()Ljava/lang/String;
    //   13: astore_2
    //   14: iconst_3
    //   15: invokestatic 179	com/facebook/common/logging/FLog:isLoggable	(I)Z
    //   18: ifeq +56 -> 74
    //   21: getstatic 79	com/tencent/bitapp/module/ModuleStateMachine:TAG	Ljava/lang/String;
    //   24: new 181	java/lang/StringBuilder
    //   27: dup
    //   28: ldc -73
    //   30: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_3
    //   34: invokeinterface 187 1 0
    //   39: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc -63
    //   44: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_0
    //   48: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc -58
    //   53: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   60: invokeinterface 202 1 0
    //   65: invokevirtual 205	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 212	com/facebook/common/logging/FLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_3
    //   75: aload_0
    //   76: getfield 88	com/tencent/bitapp/module/ModuleStateMachine:mLoadingCacheState	Lcom/tencent/bitapp/module/ModuleStateMachine$LoadingCacheState;
    //   79: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +55 -> 137
    //   85: aload_0
    //   86: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   89: astore_1
    //   90: aload_1
    //   91: monitorenter
    //   92: aload_0
    //   93: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
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
    //   120: checkcast 233	com/tencent/bitapp/module/IModuleListener
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
    //   139: getfield 102	com/tencent/bitapp/module/ModuleStateMachine:mLoadFail	Lcom/tencent/bitapp/module/ModuleStateMachine$LoadFail;
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
    //   164: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   167: astore_1
    //   168: aload_1
    //   169: monitorenter
    //   170: aload_0
    //   171: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   174: invokeinterface 221 1 0
    //   179: astore_3
    //   180: aload_3
    //   181: invokeinterface 227 1 0
    //   186: ifne +20 -> 206
    //   189: aload_0
    //   190: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   193: invokeinterface 245 1 0
    //   198: aload_1
    //   199: monitorexit
    //   200: aload_0
    //   201: iconst_0
    //   202: putfield 110	com/tencent/bitapp/module/ModuleStateMachine:mIsUpdate	Z
    //   205: return
    //   206: aload_3
    //   207: invokeinterface 231 1 0
    //   212: checkcast 233	com/tencent/bitapp/module/IModuleListener
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
    //   241: getfield 92	com/tencent/bitapp/module/ModuleStateMachine:mLoadingFileState	Lcom/tencent/bitapp/module/ModuleStateMachine$LoadingFileState;
    //   244: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   247: ifeq +55 -> 302
    //   250: aload_0
    //   251: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   254: astore_1
    //   255: aload_1
    //   256: monitorenter
    //   257: aload_0
    //   258: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
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
    //   290: checkcast 233	com/tencent/bitapp/module/IModuleListener
    //   293: aload_2
    //   294: invokeinterface 254 2 0
    //   299: goto -32 -> 267
    //   302: aload_3
    //   303: aload_0
    //   304: getfield 96	com/tencent/bitapp/module/ModuleStateMachine:mLoadingNetState	Lcom/tencent/bitapp/module/ModuleStateMachine$LoadingNetState;
    //   307: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   310: ifeq +55 -> 365
    //   313: aload_0
    //   314: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   317: astore_1
    //   318: aload_1
    //   319: monitorenter
    //   320: aload_0
    //   321: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
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
    //   353: checkcast 233	com/tencent/bitapp/module/IModuleListener
    //   356: aload_2
    //   357: invokeinterface 257 2 0
    //   362: goto -32 -> 330
    //   365: aload_3
    //   366: aload_0
    //   367: getfield 98	com/tencent/bitapp/module/ModuleStateMachine:mLoadingUnZipState	Lcom/tencent/bitapp/module/ModuleStateMachine$LoadingUnZipState;
    //   370: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   373: ifeq +55 -> 428
    //   376: aload_0
    //   377: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   380: astore_1
    //   381: aload_1
    //   382: monitorenter
    //   383: aload_0
    //   384: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
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
    //   416: checkcast 233	com/tencent/bitapp/module/IModuleListener
    //   419: aload_2
    //   420: invokeinterface 257 2 0
    //   425: goto -32 -> 393
    //   428: aload_3
    //   429: aload_0
    //   430: getfield 104	com/tencent/bitapp/module/ModuleStateMachine:mLoadingDependencies	Lcom/tencent/bitapp/module/ModuleStateMachine$LoadingDependencies;
    //   433: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   436: ifeq +55 -> 491
    //   439: aload_0
    //   440: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   443: astore_1
    //   444: aload_1
    //   445: monitorenter
    //   446: aload_0
    //   447: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   450: invokeinterface 221 1 0
    //   455: astore_3
    //   456: aload_3
    //   457: invokeinterface 227 1 0
    //   462: ifne +11 -> 473
    //   465: aload_1
    //   466: monitorexit
    //   467: return
    //   468: astore_2
    //   469: aload_1
    //   470: monitorexit
    //   471: aload_2
    //   472: athrow
    //   473: aload_3
    //   474: invokeinterface 231 1 0
    //   479: checkcast 233	com/tencent/bitapp/module/IModuleListener
    //   482: aload_2
    //   483: invokeinterface 260 2 0
    //   488: goto -32 -> 456
    //   491: aload_3
    //   492: aload_0
    //   493: getfield 100	com/tencent/bitapp/module/ModuleStateMachine:mLoadSuccess	Lcom/tencent/bitapp/module/ModuleStateMachine$LoadSuccess;
    //   496: invokevirtual 217	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   499: ifeq +142 -> 641
    //   502: invokestatic 266	com/tencent/bitapp/module/ModuleCache:getInstance	()Lcom/tencent/bitapp/module/ModuleCache;
    //   505: aload_2
    //   506: iconst_0
    //   507: anewarray 214	java/lang/Object
    //   510: invokevirtual 270	com/tencent/bitapp/module/ModuleCache:get	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   513: checkcast 272	com/tencent/bitapp/module/Module
    //   516: astore_3
    //   517: aload_0
    //   518: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   521: astore_1
    //   522: aload_1
    //   523: monitorenter
    //   524: aload_3
    //   525: ifnull +74 -> 599
    //   528: aload_0
    //   529: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   532: invokeinterface 221 1 0
    //   537: astore 4
    //   539: aload 4
    //   541: invokeinterface 227 1 0
    //   546: ifne +20 -> 566
    //   549: aload_0
    //   550: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   553: invokeinterface 245 1 0
    //   558: aload_1
    //   559: monitorexit
    //   560: aload_0
    //   561: iconst_0
    //   562: putfield 110	com/tencent/bitapp/module/ModuleStateMachine:mIsUpdate	Z
    //   565: return
    //   566: aload 4
    //   568: invokeinterface 231 1 0
    //   573: checkcast 233	com/tencent/bitapp/module/IModuleListener
    //   576: aload_2
    //   577: aload_3
    //   578: invokeinterface 276 3 0
    //   583: goto -44 -> 539
    //   586: astore_2
    //   587: aload_1
    //   588: monitorexit
    //   589: aload_2
    //   590: athrow
    //   591: astore_1
    //   592: aload_1
    //   593: invokevirtual 251	java/lang/Exception:printStackTrace	()V
    //   596: goto -36 -> 560
    //   599: aload_0
    //   600: getfield 106	com/tencent/bitapp/module/ModuleStateMachine:mSet	Ljava/util/Set;
    //   603: invokeinterface 221 1 0
    //   608: astore_3
    //   609: aload_3
    //   610: invokeinterface 227 1 0
    //   615: ifeq -66 -> 549
    //   618: aload_3
    //   619: invokeinterface 231 1 0
    //   624: checkcast 233	com/tencent/bitapp/module/IModuleListener
    //   627: aload_2
    //   628: iconst_1
    //   629: invokeinterface 248 3 0
    //   634: goto -25 -> 609
    //   637: astore_1
    //   638: goto -475 -> 163
    //   641: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	this	ModuleStateMachine
    //   0	642	1	paramVarArgs	String[]
    //   13	111	2	str1	String
    //   132	84	2	str2	String
    //   226	4	2	localObject1	Object
    //   279	15	2	str3	String
    //   342	15	2	str4	String
    //   405	15	2	str5	String
    //   468	109	2	str6	String
    //   586	42	2	str7	String
    //   4	615	3	localObject2	Object
    //   537	30	4	localIterator	java.util.Iterator
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
    //   446	456	468	finally
    //   456	467	468	finally
    //   469	471	468	finally
    //   473	488	468	finally
    //   528	539	586	finally
    //   539	549	586	finally
    //   549	560	586	finally
    //   566	583	586	finally
    //   587	589	586	finally
    //   599	609	586	finally
    //   609	634	586	finally
    //   502	524	591	java/lang/Exception
    //   589	591	591	java/lang/Exception
    //   151	159	637	java/lang/Exception
  }
  
  public void setBundleStruct(BundleStruct paramBundleStruct)
  {
    this.mBundleStruct = paramBundleStruct;
  }
  
  public void setUpdate(boolean paramBoolean)
  {
    this.mIsUpdate = paramBoolean;
  }
  
  class InitState
    extends ModuleStateMachine.ModuleLoadState
  {
    InitState()
    {
      super();
    }
    
    public void enter()
    {
      ModuleStateMachine.this.mLastState = 220;
      RNReport.reportStageStepStart(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState);
      super.enter();
    }
  }
  
  class LoadFail
    extends ModuleStateMachine.ModuleLoadState
  {
    LoadFail()
    {
      super();
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState, 6);
      super.enter();
      RNReport.reportStageEnd(ModuleStateMachine.this.mKey, 22, 6, ModuleStateMachine.this.mLastState);
    }
  }
  
  class LoadSuccess
    extends ModuleStateMachine.ModuleLoadState
  {
    LoadSuccess()
    {
      super();
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState, 0);
      RNReport.reportStageStepStart(ModuleStateMachine.this.mKey, 22, 228);
      Object localObject = ContextUtils.INSTANCE.getApplicationContext();
      if (localObject != null)
      {
        String str1 = ModuleStateMachine.this.getName();
        String str2 = Module.getJsFile(str1);
        String str3 = Md5Utils.getMd5(new File(str2));
        if (FLog.isLoggable(3)) {
          FLog.i(ModuleStateMachine.TAG, "State success, key: " + str1 + " | jsFile: " + str2 + " | jsFileMd5: " + str3);
        }
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str3)))
        {
          boolean bool2 = false;
          int j = 1;
          int i = j;
          boolean bool1 = bool2;
          if (1 != 0)
          {
            i = j;
            bool1 = bool2;
            if (!TextUtils.isEmpty(str3))
            {
              bool1 = SharedPreferencesUtils.setMd5((Context)localObject, str2, str3);
              i = bool1;
            }
          }
          bool2 = bool1;
          if (i != 0)
          {
            bool2 = bool1;
            if (!Bundle.isBase(str1))
            {
              str2 = Module.getListFile(str1);
              bool2 = SharedPreferencesUtils.setMd5((Context)localObject, str2, Md5Utils.getMd5(new File(str2)));
            }
          }
          if (FLog.isLoggable(3)) {
            FLog.i(ModuleStateMachine.TAG, "Modulecache onloadsuccess isSetMd5Success: " + bool2);
          }
          if ((bool2) && (Bundle.combin(str1)))
          {
            str2 = Bundle.getFile(str1);
            SharedPreferencesUtils.setMd5((Context)localObject, str2, Md5Utils.getMd5(new File(str2)));
            localObject = new Module(str1);
            ModuleCache.getInstance().put(str1, localObject);
          }
        }
      }
      for (;;)
      {
        RNReport.reportStageStepEnd(ModuleStateMachine.this.mKey, 22, 228, 0);
        super.enter();
        RNReport.reportStageEnd(ModuleStateMachine.this.mKey, 22, 0, ModuleStateMachine.this.mLastState);
        return;
        if (FLog.isLoggable(3))
        {
          FLog.i(ModuleStateMachine.TAG, "State success, but md5 is null");
          continue;
          if (FLog.isLoggable(3)) {
            FLog.i(ModuleStateMachine.TAG, "Context is null");
          }
        }
      }
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
      if (ModuleStateMachine.this.mIsUpdate) {}
      while (!ModuleCache.getInstance().isExistInFile(paramString)) {
        return 2;
      }
      return 1;
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState, 0);
      ModuleStateMachine.this.mLastState = 221;
      RNReport.reportStageStepStart(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState);
      super.enter();
    }
    
    public IState getFailState()
    {
      return ModuleStateMachine.this.mLoadingDependenciesFileState;
    }
    
    public IState getSuccessState()
    {
      return ModuleStateMachine.this.mLoadSuccess;
    }
  }
  
  class LoadingDependencies
    extends ConditionState
  {
    public LoadingDependencies()
    {
      super();
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState, 0);
      ModuleStateMachine.this.mLastState = 227;
      RNReport.reportStageStepStart(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState);
      super.enter();
    }
    
    public IState getFailState()
    {
      return ModuleStateMachine.this.mLoadFail;
    }
    
    public IState getSuccessState()
    {
      return ModuleStateMachine.this.mLoadSuccess;
    }
  }
  
  class LoadingDependenciesFileState
    extends ConditionState
  {
    public LoadingDependenciesFileState()
    {
      super();
    }
    
    protected int doSuccess(String paramString)
    {
      int k = 1;
      int j;
      int i;
      if (ModuleStateMachine.this.mIsUpdate)
      {
        j = 2;
        paramString = ModuleStateMachine.this.mKey;
        if (!ModuleStateMachine.this.mIsUpdate) {
          break label68;
        }
        i = k;
      }
      for (;;)
      {
        RNReport.addStageFlag(paramString, 22, 3, i);
        return j;
        if (ModuleCache.getInstance().isDependenciesExistInFile(paramString)) {}
        for (i = 1;; i = 2)
        {
          j = i;
          break;
        }
        label68:
        if (j == 2) {
          i = 2;
        } else {
          i = 3;
        }
      }
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState, 6);
      ModuleStateMachine.this.mLastState = 222;
      RNReport.reportStageStepStart(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState);
      super.enter();
    }
    
    public IState getFailState()
    {
      return ModuleStateMachine.this.mLoadingFileState;
    }
    
    public IState getSuccessState()
    {
      return ModuleStateMachine.this.mLoadSuccess;
    }
  }
  
  class LoadingDetailState
    extends ConditionState
  {
    public LoadingDetailState()
    {
      super();
    }
    
    protected int doSuccess(String paramString)
    {
      if (ModuleCache.getInstance().loadFromNet(paramString, ModuleStateMachine.this.mBundleStruct.download_url)) {
        return 1;
      }
      return 2;
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState, 6);
      ModuleStateMachine.this.mLastState = 224;
      RNReport.reportStageStepStart(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState);
      super.enter();
    }
    
    public IState getFailState()
    {
      return ModuleStateMachine.this.mLoadFail;
    }
    
    public IState getSuccessState()
    {
      return ModuleStateMachine.this.mLoadingNetState;
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
      return ModuleCache.getInstance().loadUrl(ModuleStateMachine.this.mBundleStruct, this.mStateMachine, ModuleStateMachine.this.mIsUpdate);
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState, 6);
      ModuleStateMachine.this.mLastState = 223;
      RNReport.reportStageStepStart(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState);
      super.enter();
    }
    
    public IState getFailState()
    {
      return ModuleStateMachine.this.mLoadingDetailState;
    }
    
    public IState getSuccessState()
    {
      return ModuleStateMachine.this.mLoadingDependencies;
    }
  }
  
  class LoadingNetState
    extends ConditionState
  {
    public LoadingNetState()
    {
      super();
    }
    
    protected int doSuccess(String paramString)
    {
      if (ModuleCache.getInstance().unZip(paramString, ModuleStateMachine.this.mBundleStruct)) {
        return 1;
      }
      return 2;
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState, 0);
      ModuleStateMachine.this.mLastState = 225;
      RNReport.reportStageStepStart(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState);
      super.enter();
    }
    
    public IState getFailState()
    {
      return ModuleStateMachine.this.mLoadFail;
    }
    
    public IState getSuccessState()
    {
      return ModuleStateMachine.this.mLoadingUnZipState;
    }
  }
  
  class LoadingUnZipState
    extends ConditionState
  {
    public LoadingUnZipState()
    {
      super();
    }
    
    protected int doSuccess(String paramString)
    {
      ModuleCache.getInstance().downloadDependencies(paramString, this.mStateMachine, ModuleStateMachine.this.mIsUpdate);
      return 0;
    }
    
    public void enter()
    {
      RNReport.reportStageStepEnd(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState, 0);
      ModuleStateMachine.this.mLastState = 226;
      RNReport.reportStageStepStart(ModuleStateMachine.this.mKey, 22, ModuleStateMachine.this.mLastState);
      super.enter();
    }
    
    public IState getFailState()
    {
      return ModuleStateMachine.this.mLoadFail;
    }
    
    public IState getSuccessState()
    {
      return ModuleStateMachine.this.mLoadingDependencies;
    }
  }
  
  class ModuleLoadState
    extends LoadState
  {
    public ModuleLoadState()
    {
      super();
    }
    
    public IState getNextState()
    {
      return ModuleStateMachine.this.mLoadingCacheState;
    }
    
    protected int loadCache(String paramString)
    {
      if (ModuleStateMachine.this.mIsUpdate) {}
      while (!ModuleCache.getInstance().isExistInCache(paramString)) {
        return 2;
      }
      return 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\module\ModuleStateMachine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */