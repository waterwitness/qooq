package com.tencent.mobileqq.highway.config;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mobileqq.highway.IHwManager;
import com.tencent.mobileqq.highway.iplearning.IpLearning;
import com.tencent.mobileqq.highway.iplearning.IpLearning.IpLearningAdapter;
import com.tencent.mobileqq.highway.iplearning.IpLearningImpl;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf;
import com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.highway.utils.PTVUpConfigInfo;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class ConfigManager
  implements IHwManager
{
  private static final boolean FOR_MAX = false;
  public static final int HOLES_PER_SEGMENT = 12;
  private static final String HW_CONFIG_PUSH_FILENAME = "highway_config_push";
  private static final String HW_CONFIG_SSOGET_FILENAME = "highway_config_ssoget";
  private static final boolean IS_TEST_USE_CASE = false;
  public static final int MAX_CONNECT_NUM = 1;
  public static final int MAX_PARALLEL_SEGMENT = 50;
  private static final String PROXY_TAG = "PROXY_IP";
  public static final String TAG = "ConfigManager";
  private static volatile ConfigManager mUniqueInstance;
  private Context mContext4MSFGet;
  private boolean mDomainFirst = true;
  private ArrayList<HwNetSegConf> mHCNetSegConfList = new ArrayList();
  private HardCodeIpList mHardCodeIpList;
  private boolean mHasTriggerMSFGetSucc;
  private CopyOnWriteArrayList<String> mHcDomainCandicateList;
  private ConcurrentHashMap<String, IpLearning> mIpLearners = new ConcurrentHashMap();
  private int mOperator;
  private ArrayList<Integer> mPort4HardCode;
  private IpContainer mPushIpList;
  private IpContainer mPushSsoGetIpList;
  private int mStatus = 0;
  private int maxConnNum = 1;
  
  private ConfigManager(Context paramContext, AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    this.mHCNetSegConfList.add(new HwNetSegConf(0L, 8192L, 8L, 1L));
    this.mHCNetSegConfList.add(new HwNetSegConf(1L, 32768L, 8L, 2L));
    this.mHCNetSegConfList.add(new HwNetSegConf(2L, 8192L, 2L, 1L));
    this.mHCNetSegConfList.add(new HwNetSegConf(3L, 16384L, 6L, 2L));
    this.mHCNetSegConfList.add(new HwNetSegConf(4L, 32768L, 8L, 2L));
    this.mPort4HardCode = new ArrayList();
    this.mPort4HardCode.add(Integer.valueOf(80));
    this.mPort4HardCode.add(Integer.valueOf(8080));
    this.mPort4HardCode.add(Integer.valueOf(443));
    resetSrvAddrState(paramContext, paramAppRuntime, paramString);
  }
  
  private boolean domainFirst(Context paramContext)
  {
    switch (HwNetworkUtil.getSystemNetwork(paramContext))
    {
    case 2: 
    case 3: 
    default: 
      return false;
    }
    return true;
  }
  
  private void enterError(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterError() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 7;
  }
  
  private void enterHcDomain(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterHcDomain() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 5;
    if (this.mHcDomainCandicateList.isEmpty())
    {
      if (this.mDomainFirst) {
        enterHcIp(paramContext, paramAppRuntime, paramString);
      }
    }
    else {
      return;
    }
    enterPushSsoGet(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterHcIp(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterHcIp() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 6;
    if (this.mHardCodeIpList.isEmpty(paramContext))
    {
      if (this.mDomainFirst) {
        enterPushSsoGet(paramContext, paramAppRuntime, paramString);
      }
    }
    else {
      return;
    }
    enterHcDomain(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterInit(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterInit() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 2;
    if (!this.mPushIpList.isEmpty(paramContext))
    {
      enterPushIp(paramContext, paramAppRuntime, paramString);
      return;
    }
    if (!this.mPushSsoGetIpList.isEmpty(paramContext))
    {
      enterPushSsoGet(paramContext, paramAppRuntime, paramString);
      return;
    }
    if (domainFirst(paramContext))
    {
      this.mDomainFirst = true;
      enterHcDomain(paramContext, paramAppRuntime, paramString);
      return;
    }
    this.mDomainFirst = false;
    enterHcIp(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterPre(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterPre() last status = " + getSrvAddrStatusName(this.mStatus));
    this.mStatus = 1;
    this.mPushIpList = new IpContainer(paramContext, "highway_config_push", paramAppRuntime);
    this.mPushSsoGetIpList = new IpContainer(paramContext, "highway_config_ssoget", paramAppRuntime);
    this.mHcDomainCandicateList = new CopyOnWriteArrayList();
    this.mHcDomainCandicateList.add("htdata3.qq.com");
    this.mHardCodeIpList = new HardCodeIpList();
    enterInit(paramContext, paramAppRuntime, paramString);
  }
  
  private void enterPushIp(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterPushIp() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 3;
    if (this.mPushIpList.isEmpty(paramContext)) {
      enterPushSsoGet(paramContext, paramAppRuntime, paramString);
    }
  }
  
  private void enterPushSsoGet(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("enterPushHttpget() last status = " + getSrvAddrStatusName(this.mStatus) + " Network: " + HwNetworkUtil.getNetworkName(paramContext));
    this.mStatus = 4;
    boolean bool = this.mPushSsoGetIpList.isEmpty(paramContext);
    if ((bool) || (!this.mHasTriggerMSFGetSucc))
    {
      this.mContext4MSFGet = paramContext;
      HwServlet.getConfig(paramAppRuntime, paramString);
    }
    if (bool) {
      enterError(paramContext, paramAppRuntime, paramString);
    }
  }
  
  private static boolean foundNRemoveIP(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList, String paramString)
  {
    if (paramCopyOnWriteArrayList == null) {}
    int i;
    do
    {
      return false;
      int j = 0;
      Iterator localIterator = paramCopyOnWriteArrayList.iterator();
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!((String)localIterator.next()).equalsIgnoreCase(paramString));
      i = 1;
    } while (i == 0);
    paramCopyOnWriteArrayList.remove(paramString);
    return true;
  }
  
  public static ConfigManager getInstance(Context paramContext, AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    if (mUniqueInstance == null) {
      if ((paramContext == null) || (paramAppRuntime == null) || (paramInt == 0) || (paramString == null)) {
        return null;
      }
    }
    try
    {
      if (mUniqueInstance == null) {
        mUniqueInstance = new ConfigManager(paramContext, paramAppRuntime, paramInt, paramString);
      }
      return mUniqueInstance;
    }
    finally {}
  }
  
  private HwNetSegConf getNetSegConfByType(ArrayList<HwNetSegConf> paramArrayList, int paramInt)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      HwNetSegConf localHwNetSegConf = (HwNetSegConf)paramArrayList.next();
      if (localHwNetSegConf.netType == paramInt) {
        return localHwNetSegConf;
      }
    }
    return null;
  }
  
  private IpLearning getOrCreateIpLearnerByKey(String paramString)
  {
    Object localObject;
    if ((IpLearningImpl.sEnableIpLearning == -1) || (IpLearningImpl.sEnableIpLearning == 0))
    {
      localObject = new IpLearning.IpLearningAdapter();
      this.mIpLearners.put(paramString, localObject);
      paramString = (String)localObject;
    }
    IpLearning localIpLearning;
    do
    {
      return paramString;
      localObject = new IpLearningImpl();
      localIpLearning = (IpLearning)this.mIpLearners.putIfAbsent(paramString, localObject);
      paramString = (String)localObject;
    } while (localIpLearning == null);
    return localIpLearning;
  }
  
  private EndPoint getOrderlyFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty())) {
      return new EndPoint((String)paramCopyOnWriteArrayList.get(0), ((Integer)this.mPort4HardCode.get(rand(this.mPort4HardCode.size() - 1))).intValue());
    }
    return null;
  }
  
  private EndPoint getRandomFromCandicate4HardCode(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList)
  {
    if ((paramCopyOnWriteArrayList != null) && (!paramCopyOnWriteArrayList.isEmpty())) {
      return new EndPoint((String)paramCopyOnWriteArrayList.get(rand(paramCopyOnWriteArrayList.size() - 1)), ((Integer)this.mPort4HardCode.get(rand(this.mPort4HardCode.size() - 1))).intValue());
    }
    return null;
  }
  
  private String getSrvAddrStatusName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "NONE";
    case 0: 
      return "NONE";
    case 1: 
      return "PRE";
    case 2: 
      return "INIT";
    case 3: 
      return "PUSH_IP";
    case 4: 
      return "PUSH_SSOGET";
    case 5: 
      return "HC_DOMAIN";
    }
    return "HC_IP";
  }
  
  private static void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigManager", 2, paramString);
    }
  }
  
  private void onSvrConnFailed(EndPoint paramEndPoint)
  {
    switch (this.mStatus)
    {
    case 2: 
    default: 
      return;
    case 3: 
      this.mPushIpList.onConnFailed(paramEndPoint);
      return;
    }
    this.mPushSsoGetIpList.onConnFailed(paramEndPoint);
  }
  
  private void onSvrConnSuccess(EndPoint paramEndPoint)
  {
    log("onSvrConnSuccess() IP = " + paramEndPoint.host + " mStatus:" + this.mStatus);
    switch (this.mStatus)
    {
    case 2: 
    default: 
      return;
    case 3: 
      this.mPushIpList.onConnSuccess(paramEndPoint);
      return;
    }
    this.mPushSsoGetIpList.onConnSuccess(paramEndPoint);
  }
  
  private static int rand(int paramInt)
  {
    return (int)(Math.random() * (paramInt + 1));
  }
  
  public void changeMaxConnNum(int paramInt)
  {
    if (this.maxConnNum != paramInt) {
      this.maxConnNum = paramInt;
    }
  }
  
  public SparseArray<HwNetSegConf> getAllBuzSegConfs(Context paramContext)
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(1, getNetSegConf(paramContext, 1));
    localSparseArray.put(0, getNetSegConf(paramContext, 0));
    localSparseArray.put(0, getNetSegConf(paramContext, 0));
    return localSparseArray;
  }
  
  public int getMaxConnNum()
  {
    return this.maxConnNum;
  }
  
  public HwNetSegConf getNetSegConf(Context paramContext)
  {
    return getNetSegConf(paramContext, 0);
  }
  
  public HwNetSegConf getNetSegConf(Context paramContext, int paramInt)
  {
    int i = 1;
    Object localObject = this.mHCNetSegConfList;
    ArrayList localArrayList = this.mPushIpList.getNetSegConf(paramInt);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      localObject = localArrayList;
      paramInt = 0;
      switch (HwNetworkUtil.getSystemNetwork(paramContext))
      {
      }
    }
    for (;;)
    {
      paramContext = getNetSegConfByType((ArrayList)localObject, paramInt);
      if (paramContext == null) {
        break label172;
      }
      return paramContext;
      localArrayList = this.mPushSsoGetIpList.getNetSegConf(paramInt);
      if (localArrayList != null)
      {
        paramInt = 1;
        label110:
        if (localArrayList.isEmpty()) {
          break label136;
        }
      }
      while ((paramInt & i) != 0)
      {
        localObject = localArrayList;
        break;
        paramInt = 0;
        break label110;
        label136:
        i = 0;
      }
      paramInt = 0;
      continue;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 1;
    }
    label172:
    log("getNetSegConf() cannot find segment config from PUSH or HTTP GET");
    return getNetSegConfByType(this.mHCNetSegConfList, paramInt);
  }
  
  public EndPoint getNextSrvAddr(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    EndPoint localEndPoint;
    switch (this.mStatus)
    {
    default: 
      localEndPoint = null;
    }
    while (localEndPoint != null)
    {
      log("getNextSrvAddr() IP = " + localEndPoint.host + " port=" + localEndPoint.port + "  current status = " + getSrvAddrStatusName(this.mStatus));
      return localEndPoint;
      localEndPoint = null;
      continue;
      localEndPoint = this.mPushIpList.get(paramContext);
      continue;
      localEndPoint = this.mPushSsoGetIpList.get(paramContext);
      continue;
      localEndPoint = getRandomFromCandicate4HardCode(this.mHcDomainCandicateList);
      continue;
      localEndPoint = this.mHardCodeIpList.getNextIp(paramContext);
      continue;
      localEndPoint = null;
    }
    log("getNextSrvAddr() IP = none current  status = " + getSrvAddrStatusName(this.mStatus));
    resetSrvAddrState(paramContext, paramAppRuntime, paramString);
    return localEndPoint;
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  public void onNetWorkChange(Context paramContext, AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if ((this.mStatus == 7) && (!this.mHardCodeIpList.isEmpty(paramContext)))
    {
      log("onNetWorkChange() current status = " + getSrvAddrStatusName(this.mStatus));
      enterHcIp(paramContext, paramAppRuntime, paramString);
    }
    if (paramBoolean) {
      onProxyIpChanged(paramAppRuntime);
    }
  }
  
  public void onProxyIpChanged(AppRuntime paramAppRuntime)
  {
    this.mPushIpList.addProxyIp(paramAppRuntime, true);
    this.mPushSsoGetIpList.addProxyIp(paramAppRuntime, true);
  }
  
  public void onSrvAddrPush(Context paramContext, AppRuntime paramAppRuntime, String paramString, HwConfig paramHwConfig)
  {
    log("<BDH_LOG>onSrvAddrPush() current status = " + getSrvAddrStatusName(this.mStatus));
    if ((paramHwConfig.ipConf != null) && (paramHwConfig.ipConf.uint32_refresh_cached_ip.get() == 1)) {
      refreshIpLearning();
    }
    if ((paramHwConfig.ipConf != null) && (paramHwConfig.ipConf.uint32_enable_ip_learn.get() == 1))
    {
      IpLearningImpl.sEnableIpLearning = 1;
      if (paramHwConfig.dtConf != null) {
        BdhSegTimeoutUtil.updateFromSrv(paramHwConfig.dtConf);
      }
      if (paramHwConfig.openUpConf != null) {
        OpenUpConfig.updateFromSrv(paramHwConfig.openUpConf);
      }
      if (paramHwConfig.videoConf == null) {
        break label177;
      }
      VideoUpConfigInfo.updateFromSrc(paramHwConfig.videoConf);
      label132:
      if (paramHwConfig.ptvCof == null) {
        break label195;
      }
      PTVUpConfigInfo.updateFromSrc(paramHwConfig.ptvCof);
    }
    for (;;)
    {
      if (this.mPushIpList.addNew(paramContext, paramHwConfig, paramAppRuntime)) {
        enterInit(paramContext, paramAppRuntime, paramString);
      }
      return;
      IpLearningImpl.sEnableIpLearning = 0;
      break;
      label177:
      if (!QLog.isColorLevel()) {
        break label132;
      }
      QLog.d("ConfigManager", 2, "<BDH_LOG> onSrvAddrPush : hwConfig.videoConf is null ");
      break label132;
      label195:
      if (QLog.isColorLevel()) {
        QLog.d("ConfigManager", 2, "<BDH_LOG> onSrvAddrPush : hwConfig.ptvCof is null ");
      }
    }
  }
  
  public void onSrvAddrSsoGet(HwConfig paramHwConfig, AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramHwConfig == null) || (paramHwConfig.ipList.isEmpty()) || (this.mContext4MSFGet == null)) {
      return;
    }
    log("onSrvAddrHttpGet() current status = " + getSrvAddrStatusName(this.mStatus));
    this.mHasTriggerMSFGetSucc = true;
    if ((this.mPushSsoGetIpList.addNew(this.mContext4MSFGet, paramHwConfig, paramAppRuntime)) && (this.mStatus == 7)) {
      enterPushSsoGet(this.mContext4MSFGet, paramAppRuntime, paramString);
    }
    this.mContext4MSFGet = null;
  }
  
  public void onSrvAddrUnavailable(Context paramContext, AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    if (paramInt == 3) {
      log("onSrvAddrUnavailable() connError_unreachable");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            log("onSrvAddrUnavailable() IP = " + paramString2);
            switch (this.mStatus)
            {
            case 2: 
            case 7: 
            default: 
              return;
            }
          } while (!this.mPushIpList.fail(paramString2));
          enterPushIp(paramContext, paramAppRuntime, paramString1);
          return;
        } while (!this.mPushSsoGetIpList.fail(paramString2));
        enterPushSsoGet(paramContext, paramAppRuntime, paramString1);
        return;
      } while (!foundNRemoveIP(this.mHcDomainCandicateList, paramString2));
      enterHcDomain(paramContext, paramAppRuntime, paramString1);
      return;
    } while ((this.mHardCodeIpList == null) || (!this.mHardCodeIpList.foundNRemove(paramString2)));
    enterHcIp(paramContext, paramAppRuntime, paramString1);
  }
  
  public void onSvrConnFinish(EndPoint paramEndPoint, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IpLearning", 2, " onSvrConnFinish IP = " + paramEndPoint.host + " mStatus:" + this.mStatus + " err:" + paramInt);
    }
    if (paramInt == 0) {
      onSvrConnSuccess(paramEndPoint);
    }
    while (paramInt == 3) {
      return;
    }
    onSvrConnFailed(paramEndPoint);
  }
  
  public void refreshIpLearning()
  {
    this.mIpLearners.clear();
  }
  
  public void resetSrvAddrState(Context paramContext, AppRuntime paramAppRuntime, String paramString)
  {
    log("resetSrvAddrState()");
    enterPre(paramContext, paramAppRuntime, paramString);
  }
  
  public void setOperator(int paramInt)
  {
    this.mOperator = paramInt;
  }
  
  private class Candiate
  {
    public int index;
    public String ip;
    
    public Candiate(String paramString)
    {
      this.ip = paramString;
      this.index = ConfigManager.rand(100);
    }
  }
  
  public class CustomComparator
    implements Comparator<ConfigManager.Candiate>
  {
    public CustomComparator() {}
    
    public int compare(ConfigManager.Candiate paramCandiate1, ConfigManager.Candiate paramCandiate2)
    {
      if (paramCandiate1.index < paramCandiate2.index) {
        return -1;
      }
      if (paramCandiate1.index == paramCandiate2.index) {
        return 0;
      }
      return 1;
    }
  }
  
  private class HardCodeIpList
  {
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaMobile;
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaTelecom;
    private CopyOnWriteArrayList<String> mHcIpCandicateListChinaUnicom;
    private CopyOnWriteArrayList<String> mHcIpCandicateListOverseas;
    private CopyOnWriteArrayList<String> mHcIpCandicateListWifi;
    
    public HardCodeIpList()
    {
      if (this.mHcIpCandicateListWifi == null)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        ArrayList localArrayList4 = new ArrayList();
        localArrayList3.add(new ConfigManager.Candiate(ConfigManager.this, "183.192.193.33"));
        localArrayList3.add(new ConfigManager.Candiate(ConfigManager.this, "120.196.211.21"));
        Collections.sort(localArrayList3, new ConfigManager.CustomComparator(ConfigManager.this));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "183.61.32.34"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "111.161.81.209"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "112.90.138.217"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "27.115.124.18"));
        localArrayList2.add(new ConfigManager.Candiate(ConfigManager.this, "111.161.83.190"));
        Collections.sort(localArrayList2, new ConfigManager.CustomComparator(ConfigManager.this));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "183.60.49.204"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "183.60.49.235"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "222.73.80.27"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "119.147.45.109"));
        localArrayList1.add(new ConfigManager.Candiate(ConfigManager.this, "123.151.37.14"));
        Collections.sort(localArrayList1, new ConfigManager.CustomComparator(ConfigManager.this));
        localArrayList4.add(new ConfigManager.Candiate(ConfigManager.this, "103.7.30.143"));
        localArrayList4.add(new ConfigManager.Candiate(ConfigManager.this, "203.205.140.60"));
        Collections.sort(localArrayList4, new ConfigManager.CustomComparator(ConfigManager.this));
        this.mHcIpCandicateListWifi = new CopyOnWriteArrayList();
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList3.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList4.get(0)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList3.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList4.get(1)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(2)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(2)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(3)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(3)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList1.get(4)).ip);
        this.mHcIpCandicateListWifi.add(((ConfigManager.Candiate)localArrayList2.get(4)).ip);
      }
      if (this.mHcIpCandicateListChinaMobile == null)
      {
        this.mHcIpCandicateListChinaMobile = new CopyOnWriteArrayList();
        this.mHcIpCandicateListChinaMobile.add("183.192.193.33");
        this.mHcIpCandicateListChinaMobile.add("111.30.131.145");
        this.mHcIpCandicateListChinaMobile.add("120.196.211.21");
      }
      if (this.mHcIpCandicateListChinaUnicom == null)
      {
        this.mHcIpCandicateListChinaUnicom = new CopyOnWriteArrayList();
        this.mHcIpCandicateListChinaUnicom.add("183.61.32.34");
        this.mHcIpCandicateListChinaUnicom.add("111.161.81.209");
        this.mHcIpCandicateListChinaUnicom.add("112.90.138.217");
        this.mHcIpCandicateListChinaUnicom.add("27.115.124.18");
        this.mHcIpCandicateListChinaUnicom.add("111.161.83.190");
      }
      if (this.mHcIpCandicateListChinaTelecom == null)
      {
        this.mHcIpCandicateListChinaTelecom = new CopyOnWriteArrayList();
        this.mHcIpCandicateListChinaTelecom.add("183.60.49.204");
        this.mHcIpCandicateListChinaTelecom.add("183.60.49.235");
        this.mHcIpCandicateListChinaTelecom.add("222.73.80.27");
        this.mHcIpCandicateListChinaTelecom.add("119.147.45.109");
        this.mHcIpCandicateListChinaTelecom.add("123.151.37.14");
      }
      if (this.mHcIpCandicateListOverseas == null)
      {
        this.mHcIpCandicateListOverseas = new CopyOnWriteArrayList();
        this.mHcIpCandicateListOverseas.add("103.7.30.143");
        this.mHcIpCandicateListOverseas.add("203.205.140.60");
      }
    }
    
    public boolean foundNRemove(String paramString)
    {
      if (ConfigManager.foundNRemoveIP(this.mHcIpCandicateListWifi, paramString)) {}
      while ((ConfigManager.foundNRemoveIP(this.mHcIpCandicateListChinaMobile, paramString)) || (ConfigManager.foundNRemoveIP(this.mHcIpCandicateListChinaUnicom, paramString)) || (ConfigManager.foundNRemoveIP(this.mHcIpCandicateListChinaTelecom, paramString))) {
        return true;
      }
      return false;
    }
    
    public EndPoint getNextIp(Context paramContext)
    {
      if (HwNetworkUtil.isWifiEnabled(paramContext)) {
        return ConfigManager.this.getOrderlyFromCandicate4HardCode(this.mHcIpCandicateListWifi);
      }
      switch (HwNetworkUtil.getCarrierOperatorType(paramContext))
      {
      default: 
        return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListOverseas);
      case 2: 
        return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaMobile);
      case 3: 
        return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaUnicom);
      }
      return ConfigManager.this.getRandomFromCandicate4HardCode(this.mHcIpCandicateListChinaTelecom);
    }
    
    public boolean isEmpty(Context paramContext)
    {
      if (HwNetworkUtil.isWifiEnabled(paramContext)) {
        return this.mHcIpCandicateListWifi.isEmpty();
      }
      switch (HwNetworkUtil.getCarrierOperatorType(paramContext))
      {
      default: 
        return this.mHcIpCandicateListOverseas.isEmpty();
      case 2: 
        return this.mHcIpCandicateListChinaMobile.isEmpty();
      case 3: 
        return this.mHcIpCandicateListChinaUnicom.isEmpty();
      }
      return this.mHcIpCandicateListChinaTelecom.isEmpty();
    }
  }
  
  public class IpContainer
  {
    private static final String KEY_PRE_APN = "APN_";
    private static final String KEY_PRE_BSSID = "BSSID_";
    private static final String KEY_PRE_SSID = "SSID_";
    private static final String SUB_TAG = "IpContainer.";
    private ConfigManager.PersistentConfig mCfg;
    private String mFileName;
    
    public IpContainer(Context paramContext, String paramString, AppRuntime paramAppRuntime)
    {
      this.mFileName = paramString;
      this.mCfg = readDiskOrCreateNew(paramContext, paramString);
      addProxyIp(paramAppRuntime, false);
    }
    
    private Result find(Context paramContext)
    {
      Result localResult = new Result(null);
      paramContext = getCurrentKey(paramContext);
      localResult.keyList = paramContext;
      localResult.found = false;
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        String str = (String)paramContext.next();
        ArrayList localArrayList = (ArrayList)this.mCfg.mIpList.get(str);
        if (localArrayList != null)
        {
          ConfigManager.log("IpContainer.find() key=" + str + "   value= " + ((EndPoint)localArrayList.get(0)).toString());
          localResult.found = true;
          localResult.epList = localArrayList;
        }
      }
      return localResult;
    }
    
    private boolean findNRemove(ArrayList<EndPoint> paramArrayList, String paramString)
    {
      if (paramArrayList == null)
      {
        bool2 = false;
        return bool2;
      }
      boolean bool2 = false;
      EndPoint localEndPoint = null;
      int i = 0;
      label22:
      for (boolean bool1 = bool2;; bool1 = true)
      {
        try
        {
          if (i < paramArrayList.size())
          {
            localEndPoint = (EndPoint)paramArrayList.get(i);
            if (localEndPoint.host.equalsIgnoreCase(paramString))
            {
              if (paramArrayList.size() <= i) {
                continue;
              }
              paramArrayList.remove(i);
              continue;
            }
          }
          else
          {
            bool2 = bool1;
            if (!bool1) {
              break;
            }
            bool2 = bool1;
            if (localEndPoint.protoType != 1) {
              break;
            }
            localEndPoint.protoType = 2;
            paramArrayList.add(paramArrayList.size(), localEndPoint);
            bool2 = bool1;
            break;
          }
        }
        finally {}
        i += 1;
        break label22;
      }
    }
    
    private ArrayList<String> getCurrentKey(Context paramContext)
    {
      ArrayList localArrayList = new ArrayList();
      switch (HwNetworkUtil.getSystemNetwork(paramContext))
      {
      default: 
        return localArrayList;
      case 1: 
        localArrayList.add("BSSID_" + HwNetworkUtil.getCurrentWifiBSSID(paramContext));
        localArrayList.add("SSID_" + HwNetworkUtil.getCurrentWifiSSID(paramContext));
        return localArrayList;
      }
      localArrayList.add("APN_" + HwNetworkUtil.getCurrentApn(paramContext));
      return localArrayList;
    }
    
    private void insertOrReplace(Context paramContext, ConfigManager.PersistentConfig paramPersistentConfig, ArrayList<EndPoint> paramArrayList, boolean paramBoolean)
    {
      paramContext = getCurrentKey(paramContext).iterator();
      while (paramContext.hasNext())
      {
        String str = (String)paramContext.next();
        ConfigManager.log("IpContainer.insert() key= " + str + "   value= " + ((EndPoint)paramArrayList.get(0)).toString());
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          EndPoint localEndPoint1 = (EndPoint)localIterator.next();
          EndPoint localEndPoint2 = new EndPoint(localEndPoint1.host, localEndPoint1.port, localEndPoint1.type);
          localEndPoint2.ipIndex = i;
          localEndPoint2.keyOfAPN = str;
          localEndPoint2.isSameIsp = localEndPoint1.isSameIsp;
          localArrayList.add(localEndPoint2);
          i += 1;
        }
        if (paramBoolean)
        {
          localArrayList = ConfigManager.this.getOrCreateIpLearnerByKey(str).adjustNewIpList(localArrayList);
          paramPersistentConfig.mIpList.put(str, localArrayList);
        }
        else
        {
          paramPersistentConfig.mIpList.put(str, localArrayList);
        }
      }
    }
    
    /* Error */
    private ConfigManager.PersistentConfig loadFromDisk(Context paramContext, String paramString)
    {
      // Byte code:
      //   0: new 214	java/io/File
      //   3: dup
      //   4: aload_1
      //   5: invokevirtual 220	android/content/Context:getFilesDir	()Ljava/io/File;
      //   8: invokevirtual 223	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   11: aload_2
      //   12: invokespecial 226	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   15: invokevirtual 229	java/io/File:exists	()Z
      //   18: ifne +29 -> 47
      //   21: new 97	java/lang/StringBuilder
      //   24: dup
      //   25: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   28: ldc -25
      //   30: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   33: aload_2
      //   34: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   43: aconst_null
      //   44: astore_1
      //   45: aload_1
      //   46: areturn
      //   47: aconst_null
      //   48: astore 9
      //   50: aconst_null
      //   51: astore 8
      //   53: new 233	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB
      //   56: dup
      //   57: invokespecial 234	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:<init>	()V
      //   60: astore 12
      //   62: aconst_null
      //   63: astore 5
      //   65: aconst_null
      //   66: astore 6
      //   68: aconst_null
      //   69: astore_3
      //   70: aconst_null
      //   71: astore 10
      //   73: aconst_null
      //   74: astore 11
      //   76: aconst_null
      //   77: astore 7
      //   79: aload 11
      //   81: astore 4
      //   83: aload_1
      //   84: aload_2
      //   85: invokevirtual 238	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
      //   88: astore_1
      //   89: aload 11
      //   91: astore 4
      //   93: aload_1
      //   94: astore_3
      //   95: aload_1
      //   96: astore 5
      //   98: aload_1
      //   99: astore 6
      //   101: new 240	java/io/ByteArrayOutputStream
      //   104: dup
      //   105: invokespecial 241	java/io/ByteArrayOutputStream:<init>	()V
      //   108: astore_2
      //   109: sipush 128
      //   112: newarray <illegal type>
      //   114: astore_3
      //   115: aload_1
      //   116: aload_3
      //   117: iconst_0
      //   118: aload_3
      //   119: arraylength
      //   120: invokevirtual 247	java/io/FileInputStream:read	([BII)I
      //   123: istore 13
      //   125: iload 13
      //   127: iconst_m1
      //   128: if_icmpeq +71 -> 199
      //   131: aload_2
      //   132: aload_3
      //   133: iconst_0
      //   134: iload 13
      //   136: invokevirtual 251	java/io/ByteArrayOutputStream:write	([BII)V
      //   139: goto -24 -> 115
      //   142: astore 7
      //   144: aload 8
      //   146: astore 5
      //   148: aload_2
      //   149: astore 4
      //   151: aload_1
      //   152: astore_3
      //   153: aload 7
      //   155: invokevirtual 254	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
      //   158: aload_2
      //   159: astore 4
      //   161: aload_1
      //   162: astore_3
      //   163: ldc_w 256
      //   166: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   169: aload_1
      //   170: ifnull +7 -> 177
      //   173: aload_1
      //   174: invokevirtual 259	java/io/FileInputStream:close	()V
      //   177: aload 5
      //   179: astore_1
      //   180: aload_2
      //   181: ifnull -136 -> 45
      //   184: aload_2
      //   185: invokevirtual 260	java/io/ByteArrayOutputStream:close	()V
      //   188: aload 5
      //   190: areturn
      //   191: astore_1
      //   192: aload_1
      //   193: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   196: aload 5
      //   198: areturn
      //   199: aload_2
      //   200: invokevirtual 264	java/io/ByteArrayOutputStream:flush	()V
      //   203: aload 12
      //   205: aload_2
      //   206: invokevirtual 268	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   209: invokevirtual 272	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
      //   212: pop
      //   213: new 85	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig
      //   216: dup
      //   217: aload_0
      //   218: getfield 32	com/tencent/mobileqq/highway/config/ConfigManager$IpContainer:this$0	Lcom/tencent/mobileqq/highway/config/ConfigManager;
      //   221: aconst_null
      //   222: invokespecial 275	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:<init>	(Lcom/tencent/mobileqq/highway/config/ConfigManager;Lcom/tencent/mobileqq/highway/config/ConfigManager$1;)V
      //   225: astore_3
      //   226: aload_3
      //   227: new 91	java/util/concurrent/ConcurrentHashMap
      //   230: dup
      //   231: invokespecial 276	java/util/concurrent/ConcurrentHashMap:<init>	()V
      //   234: putfield 89	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
      //   237: aload_3
      //   238: new 67	java/util/ArrayList
      //   241: dup
      //   242: invokespecial 150	java/util/ArrayList:<init>	()V
      //   245: putfield 279	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mSegConf	Ljava/util/ArrayList;
      //   248: aload_3
      //   249: new 67	java/util/ArrayList
      //   252: dup
      //   253: invokespecial 150	java/util/ArrayList:<init>	()V
      //   256: putfield 282	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mShortVideoSegConf	Ljava/util/ArrayList;
      //   259: aload 12
      //   261: getfield 286	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   264: invokevirtual 291	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   267: invokeinterface 294 1 0
      //   272: astore 4
      //   274: aload 4
      //   276: invokeinterface 77 1 0
      //   281: ifeq +187 -> 468
      //   284: aload 4
      //   286: invokeinterface 81 1 0
      //   291: checkcast 296	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
      //   294: astore 6
      //   296: aload 6
      //   298: getfield 300	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
      //   301: invokevirtual 304	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
      //   304: astore 5
      //   306: aload 6
      //   308: getfield 307	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   311: invokevirtual 291	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   314: checkcast 67	java/util/ArrayList
      //   317: astore 7
      //   319: new 67	java/util/ArrayList
      //   322: dup
      //   323: invokespecial 150	java/util/ArrayList:<init>	()V
      //   326: astore 6
      //   328: aload 7
      //   330: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   333: astore 7
      //   335: aload 7
      //   337: invokeinterface 77 1 0
      //   342: ifeq +55 -> 397
      //   345: aload 7
      //   347: invokeinterface 81 1 0
      //   352: checkcast 309	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
      //   355: astore 8
      //   357: aload 6
      //   359: new 111	com/tencent/mobileqq/highway/utils/EndPoint
      //   362: dup
      //   363: aload 8
      //   365: getfield 312	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
      //   368: invokevirtual 304	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
      //   371: aload 8
      //   373: getfield 316	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
      //   376: invokevirtual 320	com/tencent/mobileqq/pb/PBInt32Field:get	()I
      //   379: aload 8
      //   381: getfield 324	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   384: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   387: invokespecial 332	com/tencent/mobileqq/highway/utils/EndPoint:<init>	(Ljava/lang/String;IJ)V
      //   390: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   393: pop
      //   394: goto -59 -> 335
      //   397: aload_3
      //   398: getfield 89	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
      //   401: aload 5
      //   403: aload 6
      //   405: invokevirtual 206	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   408: pop
      //   409: goto -135 -> 274
      //   412: astore 7
      //   414: aload_3
      //   415: astore 6
      //   417: aload_2
      //   418: astore 4
      //   420: aload_1
      //   421: astore_3
      //   422: aload 7
      //   424: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   427: aload_2
      //   428: astore 4
      //   430: aload_1
      //   431: astore_3
      //   432: ldc_w 334
      //   435: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   438: aload_1
      //   439: ifnull +7 -> 446
      //   442: aload_1
      //   443: invokevirtual 259	java/io/FileInputStream:close	()V
      //   446: aload 6
      //   448: astore_1
      //   449: aload_2
      //   450: ifnull -405 -> 45
      //   453: aload_2
      //   454: invokevirtual 260	java/io/ByteArrayOutputStream:close	()V
      //   457: aload 6
      //   459: areturn
      //   460: astore_1
      //   461: aload_1
      //   462: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   465: aload 6
      //   467: areturn
      //   468: aload 12
      //   470: getfield 337	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_net_seg_conf_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   473: invokevirtual 291	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   476: invokeinterface 294 1 0
      //   481: astore 4
      //   483: aload 4
      //   485: invokeinterface 77 1 0
      //   490: ifeq +95 -> 585
      //   493: aload 4
      //   495: invokeinterface 81 1 0
      //   500: checkcast 339	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
      //   503: astore 5
      //   505: new 341	com/tencent/mobileqq/highway/config/HwNetSegConf
      //   508: dup
      //   509: aload 5
      //   511: getfield 344	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   514: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   517: aload 5
      //   519: getfield 347	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   522: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   525: aload 5
      //   527: getfield 350	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   530: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   533: aload 5
      //   535: getfield 353	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   538: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   541: invokespecial 356	com/tencent/mobileqq/highway/config/HwNetSegConf:<init>	(JJJJ)V
      //   544: astore 5
      //   546: aload_3
      //   547: getfield 279	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mSegConf	Ljava/util/ArrayList;
      //   550: aload 5
      //   552: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   555: pop
      //   556: goto -73 -> 483
      //   559: astore_3
      //   560: aload_2
      //   561: astore 4
      //   563: aload_3
      //   564: astore_2
      //   565: aload_1
      //   566: ifnull +7 -> 573
      //   569: aload_1
      //   570: invokevirtual 259	java/io/FileInputStream:close	()V
      //   573: aload 4
      //   575: ifnull +8 -> 583
      //   578: aload 4
      //   580: invokevirtual 260	java/io/ByteArrayOutputStream:close	()V
      //   583: aload_2
      //   584: athrow
      //   585: aload 12
      //   587: getfield 359	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_short_video_net_conf	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   590: invokevirtual 291	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   593: invokeinterface 294 1 0
      //   598: astore 4
      //   600: aload 4
      //   602: invokeinterface 77 1 0
      //   607: ifeq +69 -> 676
      //   610: aload 4
      //   612: invokeinterface 81 1 0
      //   617: checkcast 339	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
      //   620: astore 5
      //   622: new 341	com/tencent/mobileqq/highway/config/HwNetSegConf
      //   625: dup
      //   626: aload 5
      //   628: getfield 344	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   631: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   634: aload 5
      //   636: getfield 347	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   639: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   642: aload 5
      //   644: getfield 350	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   647: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   650: aload 5
      //   652: getfield 353	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   655: invokevirtual 329	com/tencent/mobileqq/pb/PBInt64Field:get	()J
      //   658: invokespecial 356	com/tencent/mobileqq/highway/config/HwNetSegConf:<init>	(JJJJ)V
      //   661: astore 5
      //   663: aload_3
      //   664: getfield 282	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mShortVideoSegConf	Ljava/util/ArrayList;
      //   667: aload 5
      //   669: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   672: pop
      //   673: goto -73 -> 600
      //   676: aload_1
      //   677: ifnull +7 -> 684
      //   680: aload_1
      //   681: invokevirtual 259	java/io/FileInputStream:close	()V
      //   684: aload_2
      //   685: ifnull +112 -> 797
      //   688: aload_2
      //   689: invokevirtual 260	java/io/ByteArrayOutputStream:close	()V
      //   692: aload_3
      //   693: areturn
      //   694: astore_1
      //   695: aload_1
      //   696: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   699: goto -15 -> 684
      //   702: astore_1
      //   703: aload_1
      //   704: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   707: aload_3
      //   708: areturn
      //   709: astore_1
      //   710: aload_1
      //   711: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   714: goto -537 -> 177
      //   717: astore_1
      //   718: aload_1
      //   719: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   722: goto -276 -> 446
      //   725: astore_1
      //   726: aload_1
      //   727: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   730: goto -157 -> 573
      //   733: astore_1
      //   734: aload_1
      //   735: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   738: goto -155 -> 583
      //   741: astore_2
      //   742: aload_3
      //   743: astore_1
      //   744: goto -179 -> 565
      //   747: astore_3
      //   748: aload_2
      //   749: astore 4
      //   751: aload_3
      //   752: astore_2
      //   753: goto -188 -> 565
      //   756: astore 7
      //   758: aload 10
      //   760: astore_2
      //   761: aload 9
      //   763: astore 6
      //   765: aload 5
      //   767: astore_1
      //   768: goto -351 -> 417
      //   771: astore 7
      //   773: aload 9
      //   775: astore 6
      //   777: goto -360 -> 417
      //   780: astore_1
      //   781: aload 7
      //   783: astore_2
      //   784: aload_1
      //   785: astore 7
      //   787: aload 8
      //   789: astore 5
      //   791: aload 6
      //   793: astore_1
      //   794: goto -646 -> 148
      //   797: aload_3
      //   798: areturn
      //   799: astore 7
      //   801: aload_3
      //   802: astore 5
      //   804: goto -656 -> 148
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	807	0	this	IpContainer
      //   0	807	1	paramContext	Context
      //   0	807	2	paramString	String
      //   69	478	3	localObject1	Object
      //   559	184	3	localPersistentConfig1	ConfigManager.PersistentConfig
      //   747	55	3	localPersistentConfig2	ConfigManager.PersistentConfig
      //   81	669	4	localObject2	Object
      //   63	740	5	localObject3	Object
      //   66	726	6	localObject4	Object
      //   77	1	7	localObject5	Object
      //   142	12	7	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
      //   317	29	7	localObject6	Object
      //   412	11	7	localIOException1	java.io.IOException
      //   756	1	7	localIOException2	java.io.IOException
      //   771	11	7	localIOException3	java.io.IOException
      //   785	1	7	localContext	Context
      //   799	1	7	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
      //   51	737	8	localHwEndPointPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwEndPointPB
      //   48	726	9	localObject7	Object
      //   71	688	10	localObject8	Object
      //   74	16	11	localObject9	Object
      //   60	526	12	localHwConfigPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwConfigPB
      //   123	12	13	i	int
      // Exception table:
      //   from	to	target	type
      //   109	115	142	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   115	125	142	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   131	139	142	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   199	226	142	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   184	188	191	java/io/IOException
      //   226	274	412	java/io/IOException
      //   274	335	412	java/io/IOException
      //   335	394	412	java/io/IOException
      //   397	409	412	java/io/IOException
      //   468	483	412	java/io/IOException
      //   483	556	412	java/io/IOException
      //   585	600	412	java/io/IOException
      //   600	673	412	java/io/IOException
      //   453	457	460	java/io/IOException
      //   226	274	559	finally
      //   274	335	559	finally
      //   335	394	559	finally
      //   397	409	559	finally
      //   468	483	559	finally
      //   483	556	559	finally
      //   585	600	559	finally
      //   600	673	559	finally
      //   680	684	694	java/io/IOException
      //   688	692	702	java/io/IOException
      //   173	177	709	java/io/IOException
      //   442	446	717	java/io/IOException
      //   569	573	725	java/io/IOException
      //   578	583	733	java/io/IOException
      //   83	89	741	finally
      //   101	109	741	finally
      //   153	158	741	finally
      //   163	169	741	finally
      //   422	427	741	finally
      //   432	438	741	finally
      //   109	115	747	finally
      //   115	125	747	finally
      //   131	139	747	finally
      //   199	226	747	finally
      //   83	89	756	java/io/IOException
      //   101	109	756	java/io/IOException
      //   109	115	771	java/io/IOException
      //   115	125	771	java/io/IOException
      //   131	139	771	java/io/IOException
      //   199	226	771	java/io/IOException
      //   83	89	780	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   101	109	780	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   226	274	799	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   274	335	799	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   335	394	799	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   397	409	799	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   468	483	799	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   483	556	799	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   585	600	799	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
      //   600	673	799	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    }
    
    private ConfigManager.PersistentConfig readDiskOrCreateNew(Context paramContext, String paramString)
    {
      paramContext = loadFromDisk(paramContext, paramString);
      if (paramContext == null)
      {
        paramContext = new ConfigManager.PersistentConfig(ConfigManager.this, null);
        paramContext.mIpList = new ConcurrentHashMap();
        paramContext.mSegConf = new ArrayList();
        paramContext.mShortVideoSegConf = new ArrayList();
        ConfigManager.log("IpContainer." + paramString + " does NOT exists.");
        return paramContext;
      }
      ConfigManager.log("IpContainer." + paramString + " does exists.");
      return paramContext;
    }
    
    /* Error */
    private void write2disk(Context paramContext, String paramString, ConfigManager.PersistentConfig paramPersistentConfig)
    {
      // Byte code:
      //   0: new 233	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB
      //   3: dup
      //   4: invokespecial 234	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:<init>	()V
      //   7: astore 6
      //   9: aload_3
      //   10: getfield 89	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
      //   13: invokevirtual 373	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
      //   16: invokeinterface 376 1 0
      //   21: astore 4
      //   23: aload 4
      //   25: invokeinterface 77 1 0
      //   30: ifeq +178 -> 208
      //   33: aload 4
      //   35: invokeinterface 81 1 0
      //   40: checkcast 378	java/util/Map$Entry
      //   43: astore 7
      //   45: aload 7
      //   47: invokeinterface 381 1 0
      //   52: checkcast 83	java/lang/String
      //   55: astore 5
      //   57: aload 7
      //   59: invokeinterface 384 1 0
      //   64: checkcast 67	java/util/ArrayList
      //   67: astore 8
      //   69: new 67	java/util/ArrayList
      //   72: dup
      //   73: invokespecial 150	java/util/ArrayList:<init>	()V
      //   76: astore 7
      //   78: aload 8
      //   80: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   83: astore 8
      //   85: aload 8
      //   87: invokeinterface 77 1 0
      //   92: ifeq +74 -> 166
      //   95: aload 8
      //   97: invokeinterface 81 1 0
      //   102: checkcast 111	com/tencent/mobileqq/highway/utils/EndPoint
      //   105: astore 9
      //   107: new 309	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
      //   110: dup
      //   111: invokespecial 385	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:<init>	()V
      //   114: astore 10
      //   116: aload 10
      //   118: getfield 312	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
      //   121: aload 9
      //   123: getfield 132	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
      //   126: invokevirtual 388	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
      //   129: aload 10
      //   131: getfield 316	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
      //   134: aload 9
      //   136: getfield 177	com/tencent/mobileqq/highway/utils/EndPoint:port	I
      //   139: invokevirtual 391	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
      //   142: aload 10
      //   144: getfield 324	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   147: aload 9
      //   149: getfield 395	com/tencent/mobileqq/highway/utils/EndPoint:timestampe	J
      //   152: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   155: aload 7
      //   157: aload 10
      //   159: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   162: pop
      //   163: goto -78 -> 85
      //   166: new 296	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
      //   169: dup
      //   170: invokespecial 399	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:<init>	()V
      //   173: astore 8
      //   175: aload 8
      //   177: getfield 300	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
      //   180: aload 5
      //   182: invokevirtual 388	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
      //   185: aload 8
      //   187: getfield 307	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   190: aload 7
      //   192: invokevirtual 402	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
      //   195: aload 6
      //   197: getfield 286	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   200: aload 8
      //   202: invokevirtual 405	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
      //   205: goto -182 -> 23
      //   208: new 67	java/util/ArrayList
      //   211: dup
      //   212: invokespecial 150	java/util/ArrayList:<init>	()V
      //   215: astore 4
      //   217: aload_3
      //   218: getfield 279	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mSegConf	Ljava/util/ArrayList;
      //   221: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   224: astore 5
      //   226: aload 5
      //   228: invokeinterface 77 1 0
      //   233: ifeq +87 -> 320
      //   236: aload 5
      //   238: invokeinterface 81 1 0
      //   243: checkcast 341	com/tencent/mobileqq/highway/config/HwNetSegConf
      //   246: astore 7
      //   248: new 339	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
      //   251: dup
      //   252: invokespecial 406	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:<init>	()V
      //   255: astore 8
      //   257: aload 8
      //   259: getfield 344	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   262: aload 7
      //   264: getfield 409	com/tencent/mobileqq/highway/config/HwNetSegConf:netType	J
      //   267: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   270: aload 8
      //   272: getfield 347	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   275: aload 7
      //   277: getfield 412	com/tencent/mobileqq/highway/config/HwNetSegConf:segSize	J
      //   280: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   283: aload 8
      //   285: getfield 350	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   288: aload 7
      //   290: getfield 415	com/tencent/mobileqq/highway/config/HwNetSegConf:segNum	J
      //   293: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   296: aload 8
      //   298: getfield 353	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   301: aload 7
      //   303: getfield 418	com/tencent/mobileqq/highway/config/HwNetSegConf:curConnNum	J
      //   306: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   309: aload 4
      //   311: aload 8
      //   313: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   316: pop
      //   317: goto -91 -> 226
      //   320: aload 6
      //   322: getfield 337	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_net_seg_conf_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   325: aload 4
      //   327: invokevirtual 402	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
      //   330: new 67	java/util/ArrayList
      //   333: dup
      //   334: invokespecial 150	java/util/ArrayList:<init>	()V
      //   337: astore 4
      //   339: aload_3
      //   340: getfield 279	com/tencent/mobileqq/highway/config/ConfigManager$PersistentConfig:mSegConf	Ljava/util/ArrayList;
      //   343: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   346: astore_3
      //   347: aload_3
      //   348: invokeinterface 77 1 0
      //   353: ifeq +86 -> 439
      //   356: aload_3
      //   357: invokeinterface 81 1 0
      //   362: checkcast 341	com/tencent/mobileqq/highway/config/HwNetSegConf
      //   365: astore 5
      //   367: new 339	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
      //   370: dup
      //   371: invokespecial 406	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:<init>	()V
      //   374: astore 7
      //   376: aload 7
      //   378: getfield 344	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   381: aload 5
      //   383: getfield 409	com/tencent/mobileqq/highway/config/HwNetSegConf:netType	J
      //   386: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   389: aload 7
      //   391: getfield 347	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   394: aload 5
      //   396: getfield 412	com/tencent/mobileqq/highway/config/HwNetSegConf:segSize	J
      //   399: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   402: aload 7
      //   404: getfield 350	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   407: aload 5
      //   409: getfield 415	com/tencent/mobileqq/highway/config/HwNetSegConf:segNum	J
      //   412: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   415: aload 7
      //   417: getfield 353	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
      //   420: aload 5
      //   422: getfield 418	com/tencent/mobileqq/highway/config/HwNetSegConf:curConnNum	J
      //   425: invokevirtual 398	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
      //   428: aload 4
      //   430: aload 7
      //   432: invokevirtual 163	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   435: pop
      //   436: goto -89 -> 347
      //   439: aload 6
      //   441: getfield 359	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_short_video_net_conf	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   444: aload 4
      //   446: invokevirtual 402	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
      //   449: new 214	java/io/File
      //   452: dup
      //   453: aload_1
      //   454: invokevirtual 220	android/content/Context:getFilesDir	()Ljava/io/File;
      //   457: invokevirtual 223	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   460: aload_2
      //   461: invokespecial 226	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   464: astore_3
      //   465: aconst_null
      //   466: astore 5
      //   468: aconst_null
      //   469: astore_1
      //   470: aconst_null
      //   471: astore 4
      //   473: new 420	java/io/FileOutputStream
      //   476: dup
      //   477: aload_3
      //   478: invokespecial 423	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   481: astore_3
      //   482: aload_3
      //   483: aload 6
      //   485: invokevirtual 424	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:toByteArray	()[B
      //   488: invokevirtual 427	java/io/FileOutputStream:write	([B)V
      //   491: new 97	java/lang/StringBuilder
      //   494: dup
      //   495: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   498: ldc_w 429
      //   501: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   504: aload_2
      //   505: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   508: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   511: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   514: aload_3
      //   515: ifnull +139 -> 654
      //   518: aload_3
      //   519: invokevirtual 430	java/io/FileOutputStream:close	()V
      //   522: return
      //   523: astore_1
      //   524: aload_1
      //   525: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   528: return
      //   529: astore_1
      //   530: aload 4
      //   532: astore_3
      //   533: aload_1
      //   534: astore 4
      //   536: aload_3
      //   537: astore_1
      //   538: aload 4
      //   540: invokevirtual 431	java/io/FileNotFoundException:printStackTrace	()V
      //   543: aload_3
      //   544: astore_1
      //   545: new 97	java/lang/StringBuilder
      //   548: dup
      //   549: invokespecial 98	java/lang/StringBuilder:<init>	()V
      //   552: ldc_w 433
      //   555: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   558: aload_2
      //   559: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   562: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   565: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   568: aload_3
      //   569: ifnull -47 -> 522
      //   572: aload_3
      //   573: invokevirtual 430	java/io/FileOutputStream:close	()V
      //   576: return
      //   577: astore_1
      //   578: aload_1
      //   579: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   582: return
      //   583: astore_3
      //   584: aload 5
      //   586: astore_2
      //   587: aload_2
      //   588: astore_1
      //   589: aload_3
      //   590: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   593: aload_2
      //   594: astore_1
      //   595: ldc_w 435
      //   598: invokestatic 120	com/tencent/mobileqq/highway/config/ConfigManager:access$500	(Ljava/lang/String;)V
      //   601: aload_2
      //   602: ifnull -80 -> 522
      //   605: aload_2
      //   606: invokevirtual 430	java/io/FileOutputStream:close	()V
      //   609: return
      //   610: astore_1
      //   611: aload_1
      //   612: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   615: return
      //   616: astore_2
      //   617: aload_1
      //   618: ifnull +7 -> 625
      //   621: aload_1
      //   622: invokevirtual 430	java/io/FileOutputStream:close	()V
      //   625: aload_2
      //   626: athrow
      //   627: astore_1
      //   628: aload_1
      //   629: invokevirtual 261	java/io/IOException:printStackTrace	()V
      //   632: goto -7 -> 625
      //   635: astore_2
      //   636: aload_3
      //   637: astore_1
      //   638: goto -21 -> 617
      //   641: astore_1
      //   642: aload_3
      //   643: astore_2
      //   644: aload_1
      //   645: astore_3
      //   646: goto -59 -> 587
      //   649: astore 4
      //   651: goto -115 -> 536
      //   654: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	655	0	this	IpContainer
      //   0	655	1	paramContext	Context
      //   0	655	2	paramString	String
      //   0	655	3	paramPersistentConfig	ConfigManager.PersistentConfig
      //   21	518	4	localObject1	Object
      //   649	1	4	localFileNotFoundException	java.io.FileNotFoundException
      //   55	530	5	localObject2	Object
      //   7	477	6	localHwConfigPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwConfigPB
      //   43	388	7	localObject3	Object
      //   67	245	8	localObject4	Object
      //   105	43	9	localEndPoint	EndPoint
      //   114	44	10	localHwEndPointPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwEndPointPB
      // Exception table:
      //   from	to	target	type
      //   518	522	523	java/io/IOException
      //   473	482	529	java/io/FileNotFoundException
      //   572	576	577	java/io/IOException
      //   473	482	583	java/io/IOException
      //   605	609	610	java/io/IOException
      //   473	482	616	finally
      //   538	543	616	finally
      //   545	568	616	finally
      //   589	593	616	finally
      //   595	601	616	finally
      //   621	625	627	java/io/IOException
      //   482	514	635	finally
      //   482	514	641	java/io/IOException
      //   482	514	649	java/io/FileNotFoundException
    }
    
    public boolean addNew(Context paramContext, HwConfig paramHwConfig, AppRuntime paramAppRuntime)
    {
      try
      {
        ConfigManager.log("IpContainer.addNew() " + paramHwConfig.ipList2String());
        long l = SystemClock.uptimeMillis();
        localObject = paramHwConfig.ipList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((EndPoint)((Iterator)localObject).next()).timestampe = l;
        }
        bool2 = false;
      }
      finally {}
      Object localObject = readDiskOrCreateNew(paramContext, this.mFileName);
      boolean bool1 = bool2;
      if (paramHwConfig != null)
      {
        bool1 = bool2;
        if (paramHwConfig.ipList != null)
        {
          bool1 = bool2;
          if (!paramHwConfig.ipList.isEmpty())
          {
            bool1 = true;
            insertOrReplace(paramContext, (ConfigManager.PersistentConfig)localObject, paramHwConfig.ipList, false);
            insertOrReplace(paramContext, this.mCfg, paramHwConfig.ipList, true);
            addProxyIp(paramAppRuntime, false);
          }
        }
      }
      boolean bool2 = bool1;
      if (paramHwConfig != null)
      {
        bool2 = bool1;
        if (paramHwConfig.netSegConfList != null)
        {
          bool2 = bool1;
          if (!paramHwConfig.netSegConfList.isEmpty())
          {
            bool2 = true;
            ((ConfigManager.PersistentConfig)localObject).mSegConf = paramHwConfig.netSegConfList;
            ((ConfigManager.PersistentConfig)localObject).mShortVideoSegConf = paramHwConfig.shortVideoSegConfList;
            this.mCfg.mSegConf = paramHwConfig.netSegConfList;
            this.mCfg.mShortVideoSegConf = paramHwConfig.shortVideoSegConfList;
          }
        }
      }
      if (bool2) {
        write2disk(paramContext, this.mFileName, (ConfigManager.PersistentConfig)localObject);
      }
      return bool2;
    }
    
    public void addProxyIp(AppRuntime paramAppRuntime, boolean paramBoolean)
    {
      Object localObject1 = ((ProxyIpManager)paramAppRuntime.getManager(3)).getProxyIp(1);
      if ((localObject1 == null) || (((List)localObject1).isEmpty()))
      {
        if (paramBoolean) {
          deleteProxyIp();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PROXY_IP", 2, "[TCP] Proxy IP List is empty!");
        }
      }
      do
      {
        return;
        deleteProxyIp();
        paramAppRuntime = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ProxyIpManager.ProxyIp)((Iterator)localObject1).next();
          paramAppRuntime.add(new EndPoint(((ProxyIpManager.ProxyIp)localObject2).ip, ((ProxyIpManager.ProxyIp)localObject2).port, 1));
        }
        int i = 0;
        localObject1 = this.mCfg.mIpList.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if (((String)localObject2).startsWith("APN_"))
          {
            i = 1;
            ((ArrayList)this.mCfg.mIpList.get(localObject2)).addAll(0, paramAppRuntime);
          }
        }
        if (i == 0)
        {
          localObject1 = getCurrentKey(BaseApplication.getContext()).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (((String)localObject2).startsWith("APN_")) {
              this.mCfg.mIpList.put(localObject2, paramAppRuntime);
            }
          }
        }
        ConfigManager.access$602(ConfigManager.this, 3);
      } while (!QLog.isColorLevel());
      QLog.d("PROXY_IP", 2, "[TCP] add " + paramAppRuntime.size() + " proxy ip to List success!");
    }
    
    public void deleteProxyIp()
    {
      if (QLog.isColorLevel()) {
        QLog.d("PROXY_IP", 2, "[TCP] clear proxy ip !");
      }
      Iterator localIterator1 = this.mCfg.mIpList.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Object localObject = (String)localIterator1.next();
        if (((String)localObject).startsWith("APN_"))
        {
          localObject = (ArrayList)this.mCfg.mIpList.get(localObject);
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator2 = ((ArrayList)localObject).iterator();
          while (localIterator2.hasNext())
          {
            EndPoint localEndPoint = (EndPoint)localIterator2.next();
            if (localEndPoint.isPorxyIp()) {
              localArrayList.add(localEndPoint);
            }
          }
          ((ArrayList)localObject).removeAll(localArrayList);
        }
      }
    }
    
    public boolean fail(String paramString)
    {
      for (;;)
      {
        Object localObject;
        boolean bool1;
        try
        {
          if ((this.mCfg == null) || (this.mCfg.mIpList == null) || (this.mCfg.mIpList.isEmpty()))
          {
            ConfigManager.log("IpContainer.fail() found due to mCfg == null || mCfg.mIpList == null || mCfg.mIpList.isEmpty()");
            bool2 = false;
            return bool2;
          }
          localObject = new ArrayList();
          bool1 = false;
          Iterator localIterator = this.mCfg.mIpList.keySet().iterator();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ArrayList localArrayList = (ArrayList)this.mCfg.mIpList.get(str);
            bool2 = bool1;
            if (findNRemove(localArrayList, paramString))
            {
              bool2 = true;
              ConfigManager.log("IpContainer.fail() remove ip " + paramString + " in " + str + " which has " + (localArrayList.size() + 1) + " IPs");
            }
            bool1 = bool2;
            if (!localArrayList.isEmpty()) {
              continue;
            }
            ((ArrayList)localObject).add(str);
            bool1 = bool2;
            continue;
          }
          paramString = ((ArrayList)localObject).iterator();
        }
        finally {}
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          ConfigManager.log("IpContainer.fail() " + (String)localObject + " is empty, remove it");
          this.mCfg.mIpList.remove(localObject);
        }
        boolean bool2 = bool1;
        if (!bool1)
        {
          ConfigManager.log("IpContainer.fail() found NONE");
          bool2 = bool1;
        }
      }
    }
    
    public EndPoint get(Context paramContext)
    {
      for (;;)
      {
        Object localObject;
        try
        {
          if (isEmpty(paramContext))
          {
            ConfigManager.log("IpContainer.get() FAIL to find IP, due to IP List is EMPTY.");
            paramContext = null;
            return paramContext;
          }
          localObject = find(paramContext);
          if (((Result)localObject).found)
          {
            paramContext = (EndPoint)((Result)localObject).epList.get(0);
            ConfigManager.log("IpContainer.get() found IP= " + paramContext.toString() + " with key= " + (String)((Result)localObject).keyList.get(0));
            continue;
          }
          l = -1L;
        }
        finally {}
        long l;
        paramContext = null;
        Iterator localIterator = this.mCfg.mIpList.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (ArrayList)((Map.Entry)localIterator.next()).getValue();
          if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
          {
            localObject = (EndPoint)((ArrayList)localObject).get(0);
            if ((localObject != null) && (((EndPoint)localObject).timestampe > l))
            {
              l = ((EndPoint)localObject).timestampe;
              paramContext = (Context)localObject;
            }
          }
        }
        if (paramContext == null)
        {
          ConfigManager.log("IpContainer.get() FAIL to find IP from RECENT added record.");
          paramContext = null;
        }
        else
        {
          ConfigManager.log("IpContainer.get() found IP from RECENT added record, ip=" + paramContext.toString());
        }
      }
    }
    
    public ArrayList<HwNetSegConf> getNetSegConf(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return this.mCfg.mSegConf;
      case 0: 
        return this.mCfg.mSegConf;
      }
      return this.mCfg.mShortVideoSegConf;
    }
    
    public ArrayList<HwNetSegConf> getNetSegConf(Context paramContext)
    {
      return getNetSegConf(0);
    }
    
    public boolean isEmpty(Context paramContext)
    {
      if ((this.mCfg == null) || (this.mCfg.mIpList == null)) {
        return true;
      }
      return this.mCfg.mIpList.isEmpty();
    }
    
    public void onConnFailed(EndPoint paramEndPoint)
    {
      if ((paramEndPoint == null) || ("".equalsIgnoreCase(paramEndPoint.keyOfAPN))) {
        return;
      }
      ConfigManager.this.getOrCreateIpLearnerByKey(paramEndPoint.keyOfAPN).onIpConnFail(paramEndPoint.host, paramEndPoint.port);
    }
    
    public void onConnSuccess(EndPoint paramEndPoint)
    {
      if ((paramEndPoint == null) || ("".equalsIgnoreCase(paramEndPoint.keyOfAPN))) {
        return;
      }
      ConfigManager.this.getOrCreateIpLearnerByKey(paramEndPoint.keyOfAPN).onIpConnSucc(paramEndPoint.host, paramEndPoint.port, paramEndPoint.isSameIsp);
    }
    
    private class Result
    {
      public ArrayList<EndPoint> epList;
      public boolean found;
      public ArrayList<String> keyList;
      
      private Result() {}
    }
  }
  
  private class PersistentConfig
  {
    public ConcurrentHashMap<String, ArrayList<EndPoint>> mIpList;
    public ArrayList<HwNetSegConf> mSegConf;
    public ArrayList<HwNetSegConf> mShortVideoSegConf;
    
    private PersistentConfig() {}
  }
  
  private static abstract interface SrvAddrStatus
  {
    public static final int ERROR = 7;
    public static final int HC_DOMAIN = 5;
    public static final int HC_IP = 6;
    public static final int INIT = 2;
    public static final int NONE = 0;
    public static final int PRE = 1;
    public static final int PUSH_IP = 3;
    public static final int PUSH_SSOGET = 4;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\highway\config\ConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */