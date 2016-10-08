package com.tencent.mobileqq.pic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.dc.PhotoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class PicStatisticsManager
  implements Manager
{
  private static final String A = "PicStatisticsManagerPicDownloadSizeSmallGroup";
  private static final String B = "PicStatisticsManagerPicDownloadSizeMiddleGroup";
  private static final String C = "PicStatisticsManagerPicDownloadSizeLargeGroup";
  private static final String D = "PicStatisticsManagerPicDownloadSizeExtraLargeGroup";
  private static final String E = "PicStatisticsManagerPicDownloadSizeLongGroup";
  private static final String F = "PicStatisticsManagerPicPreviewSizeSmallGroup";
  private static final String G = "PicStatisticsManagerPicPreviewSizeMiddleGroup";
  private static final String H = "PicStatisticsManagerPicPreviewSizeLargeGroup";
  private static final String I = "PicStatisticsManagerPicPreivewSizeExtraLargeGroup";
  private static final String J = "PicStatisticsManagerPicPreviewSizeLongGroup";
  private static final String K = "PicStatisticsManagerDiffSizePicPreviewC2CDynamic";
  private static final String L = "PicStatisticsManagerPicDownloadSizeSmallC2CDynamic";
  private static final String M = "PicStatisticsManagerPicDownloadSizeMiddleC2CDynamic";
  private static final String N = "PicStatisticsManagerPicDownloadSizeLargeC2CDynamic";
  private static final String O = "PicStatisticsManagerPicDownloadSizeExtraLargeC2CDynamic";
  private static final String P = "PicStatisticsManagerPicDownloadSizeLongC2CDynamic";
  private static final String Q = "PicStatisticsManagerPicPreviewSizeSmallC2CDynamic";
  private static final String R = "PicStatisticsManagerPicPreviewSizeMiddleC2CDynamic";
  private static final String S = "PicStatisticsManagerPicPreviewSizeLargeC2CDynamic";
  private static final String T = "PicStatisticsManagerPicPreivewSizeExtraLargeC2CDynamic";
  private static final String U = "PicStatisticsManagerPicPreviewSizeLongC2CDynamic";
  private static final String V = "PicStatisticsManagerDiffSizePicPreviewGroupDynamic";
  private static final String W = "PicStatisticsManagerPicDownloadSizeSmallGroupDynamic";
  private static final String X = "PicStatisticsManagerPicDownloadSizeMiddleGroupDynamic";
  private static final String Y = "PicStatisticsManagerPicDownloadSizeLargeGroupDynamic";
  private static final String Z = "PicStatisticsManagerPicDownloadSizeExtraLargeGroupDynamic";
  public static final int a = 13057;
  public static final String a = "PicStatisticsManagerUploadPic";
  private static final List jdField_a_of_type_JavaUtilList;
  private static final String[][] jdField_a_of_type_Array2dOfJavaLangString;
  private static final String aA = "PicStatisticsManagerPredownloadCount4G";
  private static final String aB = "PicStatisticsManagerPredownloadCountXG";
  private static final String aC = "PicStatisticsManagerPreviewCountWifi";
  private static final String aD = "PicStatisticsManagerPreviewCount4G";
  private static final String aE = "PicStatisticsManagerPreviewCountXG";
  private static final String aF = "XG_C2C_FLOAT_HIT_COUNT";
  private static final String aG = "4G_C2C_FLOAT_HIT_COUNT";
  private static final String aH = "PicStatisticsManagerPredownloadThumbPic";
  private static final String aI = "PicStatisticsManagerPreDownloadThumbPicCount";
  private static final String aJ = "PicStatisticsManagerPreDownloadThumbPicHitCount";
  private static final String aK = "PicStatisticsManagerPreDownloadThumbPicMissCount";
  private static final String aL = "PicStatisticsManagerPredownloadMissReasonGrayForWifi";
  private static final String aM = "PicStatisticsManagerPredownloadMissReasonGrayForXG";
  private static final String aN = "PredownloadMissReason";
  private static final String aa = "PicStatisticsManagerPicDownloadSizeLongGroupDynamic";
  private static final String ab = "PicStatisticsManagerPicPreviewSizeSmallGroupDynamic";
  private static final String ac = "PicStatisticsManagerPicPreviewSizeMiddleGroupDynamic";
  private static final String ad = "PicStatisticsManagerPicPreviewSizeLargeGroupDynamic";
  private static final String ae = "PicStatisticsManagerPicPreivewSizeExtraLargeGroupDynamic";
  private static final String af = "PicStatisticsManagerPicPreviewSizeLongGroupDynamic";
  private static final String ag = "PicStatisticsManagerPredownloadMissPriorityWifi";
  private static final String ah = "PicStatisticsManagerMissPriorityHandlingWifi";
  private static final String ai = "PicStatisticsManagerMissPriorityAIOWifi";
  private static final String aj = "PicStatisticsManagerMissPriorityC2CWifi";
  private static final String ak = "PicStatisticsManagerMissPriorityDiscussionWifi";
  private static final String al = "PicStatisticsManagerMissPriorityGroupWifi";
  private static final String am = "PicStatisticsManagerMissPriorityWaitingWifi";
  private static final String an = "PicStatisticsManagerMissPriorityUnknownWifi";
  private static final String ao = "PicStatisticsManagerPredownloadMissPriorityXG";
  private static final String ap = "PicStatisticsManagerMissPriorityHandlingXG";
  private static final String aq = "PicStatisticsManagerMissPriorityAIOXG";
  private static final String ar = "PicStatisticsManagerMissPriorityC2CXG";
  private static final String as = "PicStatisticsManagerMissPriorityDiscussionXG";
  private static final String at = "PicStatisticsManagerMissPriorityGroupXG";
  private static final String au = "PicStatisticsManagerMissPriorityWaitingXG";
  private static final String av = "PicStatisticsManagerMissPriorityUnknownXG";
  private static final String aw = "PicStatisticsManagerPredownloadDataWifi";
  private static final String ax = "PicStatisticsManagerPredownloadData4g";
  private static final String ay = "PicStatisticsManagerPredownloadDataXg";
  private static final String az = "PicStatisticsManagerPredownloadCountWifi";
  public static final int b = 13058;
  private static final String jdField_b_of_type_JavaLangString;
  private static final List jdField_b_of_type_JavaUtilList;
  private static final String[][] jdField_b_of_type_Array2dOfJavaLangString;
  public static final int c = 13059;
  private static final String jdField_c_of_type_JavaLangString = "PicStatisticsManagerFirstUsed";
  private static final List jdField_c_of_type_JavaUtilList;
  private static final String[][] jdField_c_of_type_Array2dOfJavaLangString;
  public static final int d = 13060;
  private static final String jdField_d_of_type_JavaLangString = "PicStatisticsManagerSendPicTotalSize";
  private static final List jdField_d_of_type_JavaUtilList;
  private static final String[][] jdField_d_of_type_Array2dOfJavaLangString;
  private static final int jdField_e_of_type_Int;
  private static final String jdField_e_of_type_JavaLangString = "PicStatisticsManagerForwardPicTotalSize";
  private static final List jdField_e_of_type_JavaUtilList;
  private static final String jdField_f_of_type_JavaLangString = "PicStatisticsManagerSendPicCount";
  private static final List jdField_f_of_type_JavaUtilList;
  private static final String jdField_g_of_type_JavaLangString = "PicStatisticsManagerForwardPicCount";
  private static final List jdField_g_of_type_JavaUtilList;
  private static final String jdField_h_of_type_JavaLangString = "PicStatisticsManagerIsUploadPicActive";
  private static final List jdField_h_of_type_JavaUtilList;
  private static final String jdField_i_of_type_JavaLangString = "PicStatisticsManagerDownloadPic";
  private static final List jdField_i_of_type_JavaUtilList;
  private static final String jdField_j_of_type_JavaLangString = "PicStatisticsManagerThumbPicTotalSize";
  private static final List jdField_j_of_type_JavaUtilList;
  private static final String jdField_k_of_type_JavaLangString = "PicStatisticsManagerBigPicTotalSize";
  private static final List jdField_k_of_type_JavaUtilList;
  private static final String jdField_l_of_type_JavaLangString = "PicStatisticsManagerDownloadThumbPicCount";
  private static final List jdField_l_of_type_JavaUtilList;
  private static final String m = "PicStatisticsManagerDownloadBigPicCount";
  private static final String n = "PicStatisticsManagerIsDownloadPicActive";
  private static final String o = "PicStatisticsManagerDiffSizePicPreviewC2C";
  private static final String p = "PicStatisticsManagerPicDownloadSizeSmallC2C";
  private static final String q = "PicStatisticsManagerPicDownloadSizeMiddleC2C";
  private static final String r = "PicStatisticsManagerPicDownloadSizeLargeC2C";
  private static final String s = "PicStatisticsManagerPicDownloadSizeExtraLargeC2C";
  private static final String t = "PicStatisticsManagerPicDownloadSizeLongC2C";
  private static final String u = "PicStatisticsManagerPicPreviewSizeSmallC2C";
  private static final String v = "PicStatisticsManagerPicPreviewSizeMiddleC2C";
  private static final String w = "PicStatisticsManagerPicPreviewSizeLargeC2C";
  private static final String x = "PicStatisticsManagerPicPreivewSizeExtraLargeC2C";
  private static final String y = "PicStatisticsManagerPicPreviewSizeLongC2C";
  private static final String z = "PicStatisticsManagerDiffSizePicPreviewGroup";
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Set jdField_a_of_type_JavaUtilSet;
  private Set jdField_b_of_type_JavaUtilSet;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_b_of_type_JavaLangString = PicStatisticsManager.class.getSimpleName();
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerSendPicTotalSize");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerForwardPicTotalSize");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerSendPicCount");
    jdField_a_of_type_JavaUtilList.add("PicStatisticsManagerForwardPicCount");
    jdField_b_of_type_JavaUtilList = new ArrayList();
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerThumbPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerBigPicTotalSize");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerDownloadThumbPicCount");
    jdField_b_of_type_JavaUtilList.add("PicStatisticsManagerDownloadBigPicCount");
    jdField_c_of_type_JavaUtilList = new ArrayList();
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeSmallC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeMiddleC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLongC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeSmallC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeMiddleC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2C");
    jdField_c_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLongC2C");
    jdField_d_of_type_JavaUtilList = new ArrayList();
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeSmallGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeMiddleGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLongGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeSmallGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeMiddleGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroup");
    jdField_d_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLongGroup");
    jdField_e_of_type_JavaUtilList = new ArrayList();
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeSmallC2CDynamic");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeMiddleC2CDynamic");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLargeC2CDynamic");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeExtraLargeC2CDynamic");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerPicDownloadSizeLongC2CDynamic");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeSmallC2CDynamic");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeMiddleC2CDynamic");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLargeC2CDynamic");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerPicPreivewSizeExtraLargeC2CDynamic");
    jdField_e_of_type_JavaUtilList.add("PicStatisticsManagerPicPreviewSizeLongC2CDynamic");
    f = new ArrayList();
    f.add("PicStatisticsManagerPicDownloadSizeSmallGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeMiddleGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeLargeGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeExtraLargeGroupDynamic");
    f.add("PicStatisticsManagerPicDownloadSizeLongGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeSmallGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeMiddleGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeLargeGroupDynamic");
    f.add("PicStatisticsManagerPicPreivewSizeExtraLargeGroupDynamic");
    f.add("PicStatisticsManagerPicPreviewSizeLongGroupDynamic");
    g = new ArrayList();
    g.add("PicStatisticsManagerMissPriorityHandlingWifi");
    g.add("PicStatisticsManagerMissPriorityAIOWifi");
    g.add("PicStatisticsManagerMissPriorityC2CWifi");
    g.add("PicStatisticsManagerMissPriorityDiscussionWifi");
    g.add("PicStatisticsManagerMissPriorityGroupWifi");
    g.add("PicStatisticsManagerMissPriorityWaitingWifi");
    g.add("PicStatisticsManagerMissPriorityUnknownWifi");
    h = new ArrayList();
    h.add("PicStatisticsManagerMissPriorityHandlingXG");
    h.add("PicStatisticsManagerMissPriorityAIOXG");
    h.add("PicStatisticsManagerMissPriorityC2CXG");
    h.add("PicStatisticsManagerMissPriorityDiscussionXG");
    h.add("PicStatisticsManagerMissPriorityGroupXG");
    h.add("PicStatisticsManagerMissPriorityWaitingXG");
    h.add("PicStatisticsManagerMissPriorityUnknownXG");
    jdField_a_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicCount", "WifiDiscussionBigPicCount", "WifiGroupBigPicCount", "WifiDigitalGroupBigPicCount" }, { "4GC2CBigPicCount", "4GDiscussionBigPicCount", "4GGroupBigPicCount", "4GDigitalGroupBigPicCount" }, { "XGC2CBigPicCount", "XGDiscussionBigPicCount", "XGGroupBigPicCount", "XGDigitalGroupBigPicCount" } };
    String[] arrayOfString = { "4GC2CBigPicHitCount", "4GDiscussionBigPicHitCount", "4GGroupBigPicHitCount", "4GDigitalGroupBigPicHitCount" };
    jdField_b_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicHitCount", "WifiDiscussionBigPicHitCount", "WifiGroupBigPicHitCount", "WifiDigitalGroupBigPicHitCount" }, arrayOfString, { "XGC2CBigPicHitCount", "XGDiscussionBigPicHitCount", "XGGroupBigPicHitCount", "XGDigitalGroupBigPicHitCount" } };
    jdField_c_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicMissCount", "WifiDiscussionBigPicMissCount", "WifiGroupBigPicMissCount", "WifiDigitalGroupBigPicMissCount" }, { "4GC2CBigPicMissCount", "4GDiscussionBigPicMissCount", "4GGroupBigPicMissCount", "4GDigitalGroupBigPicMissCount" }, { "XGC2CBigPicMissCount", "XGDiscussionBigPicMissCount", "XGGroupBigPicMissCount", "XGDigitalGroupBigPicMissCount" } };
    jdField_d_of_type_Array2dOfJavaLangString = new String[][] { { "WifiC2CBigPicNotSupportCount", "WifiDiscussionBigPicNotSupportCount", "WifiGroupBigPicNotSupportCount", "WifiDigitalGroupBigPicNotSupportCount" }, { "4GC2CBigPicNotSupportCount", "4GDiscussionBigPicNotSupportCount", "4GGroupBigPicNotSupportCount", "4GDigitalGroupBigPicNotSupportCount" }, { "XGC2CBigPicNotSupportCount", "XGDiscussionBigPicNotSupportCount", "XGGroupBigPicNotSupportCount", "XGDigitalGroupBigPicNotSupportCount" } };
    jdField_e_of_type_Int = jdField_a_of_type_Array2dOfJavaLangString[0].length;
    i = new ArrayList();
    j = new ArrayList();
    k = new ArrayList();
    int i1 = 0;
    while (i1 < jdField_e_of_type_Int)
    {
      i.add(jdField_a_of_type_Array2dOfJavaLangString[0][i1]);
      i.add(jdField_b_of_type_Array2dOfJavaLangString[0][i1]);
      i.add(jdField_c_of_type_Array2dOfJavaLangString[0][i1]);
      i.add(jdField_d_of_type_Array2dOfJavaLangString[0][i1]);
      j.add(jdField_a_of_type_Array2dOfJavaLangString[1][i1]);
      j.add(jdField_b_of_type_Array2dOfJavaLangString[1][i1]);
      j.add(jdField_c_of_type_Array2dOfJavaLangString[1][i1]);
      j.add(jdField_d_of_type_Array2dOfJavaLangString[1][i1]);
      k.add(jdField_a_of_type_Array2dOfJavaLangString[2][i1]);
      k.add(jdField_b_of_type_Array2dOfJavaLangString[2][i1]);
      k.add(jdField_c_of_type_Array2dOfJavaLangString[2][i1]);
      k.add(jdField_d_of_type_Array2dOfJavaLangString[2][i1]);
      i1 += 1;
    }
    j.add("4G_C2C_FLOAT_HIT_COUNT");
    k.add("XG_C2C_FLOAT_HIT_COUNT");
    l = new ArrayList();
    l.add("PicStatisticsManagerPreDownloadThumbPicCount");
    l.add("PicStatisticsManagerPreDownloadThumbPicHitCount");
    l.add("PicStatisticsManagerPreDownloadThumbPicMissCount");
  }
  
  public PicStatisticsManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "PicStatisticsManagerMissPriorityUnknownWifi";
    case 6: 
      return "PicStatisticsManagerMissPriorityHandlingWifi";
    case 5: 
      return "PicStatisticsManagerMissPriorityAIOWifi";
    case 4: 
      return "PicStatisticsManagerMissPriorityC2CWifi";
    case 3: 
      return "PicStatisticsManagerMissPriorityDiscussionWifi";
    }
    return "PicStatisticsManagerMissPriorityGroupWifi";
  }
  
  private HashMap a(List paramList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L);
      long l1;
      if (l2 >= 0L)
      {
        l1 = l2;
        if (l2 <= 10000L) {}
      }
      else
      {
        l1 = 0L;
      }
      localHashMap.put(str, String.valueOf(l1));
    }
    return localHashMap;
  }
  
  private void a(int paramInt1, int paramInt2, String[][] paramArrayOfString, boolean paramBoolean)
  {
    long l1;
    String str1;
    String str2;
    if (paramInt1 == 0) {
      if (paramBoolean)
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPredownloadCountWifi", l1 + 1L);
        paramInt1 = 0;
        str1 = "WIFI";
        if (paramInt2 != 3) {
          break label364;
        }
        paramInt2 = 0;
        str2 = "C2C";
        label58:
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "addCount(): networkType=" + str1 + " uin=" + str2);
        }
        paramArrayOfString = paramArrayOfString[paramInt1][paramInt2];
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(paramArrayOfString, 0L) + 1L;
        if (Build.VERSION.SDK_INT < 9) {
          break label425;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramArrayOfString, l1).apply();
      }
    }
    label364:
    do
    {
      return;
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCountWifi", l1 + 1L);
      paramInt1 = 0;
      str1 = "WIFI";
      break;
      if (paramInt1 == 0)
      {
        if (paramBoolean)
        {
          l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCount4G", 0L);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPredownloadCount4G", l1 + 1L);
          paramInt1 = 1;
          str1 = "4G";
          break;
        }
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCount4G", l1 + 1L);
        paramInt1 = 1;
        str1 = "4G";
        break;
      }
      if (paramBoolean)
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPredownloadCountXG", l1 + 1L);
        paramInt1 = 2;
        str1 = "XG";
        break;
      }
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCountXG", l1 + 1L);
      paramInt1 = 2;
      str1 = "XG";
      break;
      if (paramInt2 == 2)
      {
        paramInt2 = 1;
        str2 = "Discussion";
        break label58;
      }
      if (paramInt2 == 0)
      {
        paramInt2 = 2;
        str2 = "Group";
        break label58;
      }
      if (paramInt2 == 1)
      {
        paramInt2 = 3;
        str2 = "Digital Group";
        break label58;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_b_of_type_JavaLangString, 2, "addCount(): Error! Unknown uin type");
    return;
    label425:
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(paramArrayOfString, l1).commit();
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "PicStatisticsManagerMissPriorityUnknownXG";
    case 6: 
      return "PicStatisticsManagerMissPriorityHandlingXG";
    case 5: 
      return "PicStatisticsManagerMissPriorityAIOXG";
    case 4: 
      return "PicStatisticsManagerMissPriorityC2CXG";
    case 3: 
      return "PicStatisticsManagerMissPriorityDiscussionXG";
    }
    return "PicStatisticsManagerMissPriorityGroupXG";
  }
  
  private void b()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = g.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = h.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = i.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = k.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    localIterator = l.iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, 0L);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("PicStatisticsManagerFirstUsed", false))
    {
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PicStatisticsManagerFirstUsed", true).apply();
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "dataReport(): Not need to data report!");
        }
        return;
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PicStatisticsManagerFirstUsed", true).commit();
      }
    }
    String str;
    label110:
    long l1;
    long l2;
    HashMap localHashMap1;
    label166:
    HashMap localHashMap2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) > 0L) {
        break label270;
      }
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerSendPicCount", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerForwardPicCount", 0L);
      localHashMap1 = a(jdField_a_of_type_JavaUtilList);
      if (l1 + l2 > 0L) {
        break label662;
      }
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "FALSE");
      StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerUploadPic", false, 0L, 0L, localHashMap1, "");
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerDownloadThumbPicCount", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerDownloadBigPicCount", 0L);
      localHashMap2 = a(jdField_b_of_type_JavaUtilList);
      if (l1 + l2 > 0L) {
        break label675;
      }
      localHashMap1.put("PicStatisticsManagerIsDownloadPicActive", "FALSE");
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDownloadPic", false, 0L, 0L, localHashMap2, "");
      b();
      return;
      str = null;
      break;
      label270:
      StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadThumbPic", false, 0L, 0L, a(l), "");
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountWifi", 0L);
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCountXG", 0L);
      long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPredownloadCount4G", 0L);
      long l4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountWifi", 0L);
      long l5 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
      long l6 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
      if (l1 + l4 > 0L) {
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadDataWifi", false, 0L, 0L, a(i), "");
      }
      if (l3 + l6 > 0L) {
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadData4g", false, 0L, 0L, a(j), "");
      }
      if (l2 + l5 > 0L) {
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadDataXg", false, 0L, 0L, a(k), "");
      }
      if (l4 + l5 > 0L)
      {
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDiffSizePicPreviewC2C", false, 0L, 0L, a(jdField_c_of_type_JavaUtilList), "");
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDiffSizePicPreviewGroup", false, 0L, 0L, a(jdField_d_of_type_JavaUtilList), "");
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDiffSizePicPreviewC2CDynamic", false, 0L, 0L, a(jdField_e_of_type_JavaUtilList), "");
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerDiffSizePicPreviewGroupDynamic", false, 0L, 0L, a(f), "");
      }
      if (l4 > 0L) {
        StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissPriorityWifi", false, 0L, 0L, a(g), "");
      }
      if (l5 <= 0L) {
        break label110;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissPriorityXG", false, 0L, 0L, a(h), "");
      break label110;
      label662:
      localHashMap1.put("PicStatisticsManagerIsUploadPicActive", "TRUE");
      break label166;
      label675:
      localHashMap1.put("PicStatisticsManagerIsDownloadPicActive", "TRUE");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    HashMap localHashMap;
    for (String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();; str = null)
    {
      localHashMap = new HashMap();
      localHashMap.put("PredownloadMissReason", String.valueOf(paramInt2));
      if (paramInt1 != 0) {
        break;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissReasonGrayForWifi", false, 0L, 0L, localHashMap, "");
      return;
    }
    StatisticCollector.a(BaseApplication.getContext()).a(str, "PicStatisticsManagerPredownloadMissReasonGrayForXG", false, 0L, 0L, localHashMap, "");
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDownloadBigPicHitCount(): networkType=" + paramInt1 + " uin=" + paramInt2 + " preDownloadState=" + paramInt3);
    }
    if (paramInt3 == 1)
    {
      long l1;
      long l2;
      if (paramInt1 == 2)
      {
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("XG_C2C_FLOAT_HIT_COUNT", 0L);
        l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCountXG", 0L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCountXG", l2 + 1L);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("XG_C2C_FLOAT_HIT_COUNT", l1 + 1L);
        if (Build.VERSION.SDK_INT >= 9) {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
        }
      }
      else
      {
        do
        {
          return;
          if (paramInt1 == 1)
          {
            l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("4G_C2C_FLOAT_HIT_COUNT", 0L);
            l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreviewCount4G", 0L);
            this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreviewCount4G", l2 + 1L);
            this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("4G_C2C_FLOAT_HIT_COUNT", l1 + 1L);
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDownloadBigPicHitCount(): Error, not 3G or 4G, Float hit");
        return;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return;
    }
    a(paramInt1, paramInt2, jdField_b_of_type_Array2dOfJavaLangString, false);
  }
  
  public void a(int paramInt, long paramLong)
  {
    String str3;
    String str2;
    String str1;
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "addPicData(): Unknown picture type!");
      }
      return;
    case 13057: 
      str3 = "SendPic";
      str2 = "PicStatisticsManagerSendPicTotalSize";
      str1 = "PicStatisticsManagerSendPicCount";
    }
    long l1;
    long l2;
    for (;;)
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str2, 0L) + paramLong;
      l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str1, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "addPictureData(): type=" + str3 + " Adding Size=" + paramLong + " Total Size=" + l1 + " Count=" + l2);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l1).putLong(str1, l2).apply();
      return;
      str3 = "ForwardPic";
      str2 = "PicStatisticsManagerForwardPicTotalSize";
      str1 = "PicStatisticsManagerForwardPicCount";
      continue;
      str3 = "DownloadThumbPic";
      str2 = "PicStatisticsManagerThumbPicTotalSize";
      str1 = "PicStatisticsManagerDownloadThumbPicCount";
      continue;
      str3 = "DownloadBigPic";
      str2 = "PicStatisticsManagerBigPicTotalSize";
      str1 = "PicStatisticsManagerDownloadBigPicCount";
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l1).putLong(str1, l2).commit();
  }
  
  public void a(MessageForPic paramMessageForPic)
  {
    for (;;)
    {
      try
      {
        String str = paramMessageForPic.md5;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDownloadThumbPic(): Uniseq=" + paramMessageForPic.uniseq + " MD5=" + paramMessageForPic.md5);
        }
        boolean bool = this.jdField_a_of_type_JavaUtilSet.contains(str);
        if (bool) {
          return;
        }
        this.jdField_a_of_type_JavaUtilSet.add(paramMessageForPic.md5);
        long l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicCount", 0L) + 1L;
        if (Build.VERSION.SDK_INT >= 9)
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l1).apply();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "addPreDownloadThumbPic(): PreDownloadThumbPicCount=" + l1);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicCount", l1).commit();
        }
      }
      finally {}
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDowonloadBigPicCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_a_of_type_Array2dOfJavaLangString, true);
  }
  
  public void b(MessageForPic paramMessageForPic)
  {
    for (;;)
    {
      long l1;
      try
      {
        String str = paramMessageForPic.md5;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDownloadBigPic(): Uniseq=" + paramMessageForPic.uniseq + " MD5=" + str);
        }
        boolean bool = this.jdField_b_of_type_JavaUtilSet.contains(str);
        if (bool) {
          return;
        }
        this.jdField_b_of_type_JavaUtilSet.add(str);
        if (this.jdField_a_of_type_JavaUtilSet.contains(str))
        {
          l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicHitCount", 0L);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicHitCount", l1 + 1L);
          if (Build.VERSION.SDK_INT < 9) {
            break label181;
          }
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
          continue;
        }
        l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PicStatisticsManagerPreDownloadThumbPicMissCount", 0L);
      }
      finally {}
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("PicStatisticsManagerPreDownloadThumbPicMissCount", l1 + 1L);
      continue;
      label181:
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDownloadBigPicMissCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_c_of_type_Array2dOfJavaLangString, false);
  }
  
  public void c(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "addDownloadBigPicSize(): pic is null");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = paramMessageForPic.width;
      l2 = paramMessageForPic.height;
      if ((l1 > 0L) && (l2 > 0L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_b_of_type_JavaLangString, 2, "addDownloadBigPicSize(): Width=" + l1 + " Height=" + l2 + ", invalid!");
    return;
    int i1;
    int i2;
    String str1;
    if (PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3)
    {
      i1 = 1;
      i2 = PhotoUtils.a(l1, l2);
      if (i2 != 0) {
        break label296;
      }
      if (i1 == 0) {
        break label290;
      }
      str1 = "PicStatisticsManagerPicDownloadSizeLongC2C";
    }
    String str2;
    long l3;
    for (;;)
    {
      str2 = str1;
      if (PeakUtils.a(paramMessageForPic.imageType)) {
        str2 = str1 + "Dynamic";
      }
      l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str2, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "addDownloadBigPicSize(): " + str2 + ", Width=" + l1 + " Height=" + l2 + " Count=" + l3);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break label386;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).apply();
      return;
      i1 = 0;
      break;
      label290:
      str1 = "PicStatisticsManagerPicDownloadSizeLongGroup";
      continue;
      label296:
      if (i2 == 1)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeSmallC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeSmallGroup";
        }
      }
      else if (i2 == 2)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeMiddleC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeMiddleGroup";
        }
      }
      else if (i2 == 3)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicDownloadSizeLargeC2C";
        } else {
          str1 = "PicStatisticsManagerPicDownloadSizeLargeGroup";
        }
      }
      else if (i1 != 0) {
        str1 = "PicStatisticsManagerPicDownloadSizeExtraLargeC2C";
      } else {
        str1 = "PicStatisticsManagerPicDownloadSizeExtraLargeGroup";
      }
    }
    label386:
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).commit();
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreDownloadNotSupportCount(): networkType=" + paramInt1 + " uin=" + paramInt2);
    }
    a(paramInt1, paramInt2, jdField_d_of_type_Array2dOfJavaLangString, false);
  }
  
  public void d(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic == null) {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "addPreviewBigPicSize(): pic is null");
      }
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = paramMessageForPic.width;
      l2 = paramMessageForPic.height;
      if ((l1 > 0L) && (l2 > 0L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreviewBigPicSize(): Width=" + l1 + " Height=" + l2 + ", invalid!");
    return;
    int i1;
    int i2;
    String str1;
    if (PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic.istroop, paramMessageForPic.frienduin) == 3)
    {
      i1 = 1;
      i2 = PhotoUtils.a(l1, l2);
      if (i2 != 0) {
        break label296;
      }
      if (i1 == 0) {
        break label290;
      }
      str1 = "PicStatisticsManagerPicPreviewSizeLongC2C";
    }
    String str2;
    long l3;
    for (;;)
    {
      str2 = str1;
      if (PeakUtils.a(paramMessageForPic.imageType)) {
        str2 = str1 + "Dynamic";
      }
      l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str2, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "addPreviewBigPicSize(): " + str2 + ", Width=" + l1 + " Height=" + l2 + " Count=" + l3);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break label386;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).apply();
      return;
      i1 = 0;
      break;
      label290:
      str1 = "PicStatisticsManagerPicPreviewSizeLongGroup";
      continue;
      label296:
      if (i2 == 1)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeSmallC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeSmallGroup";
        }
      }
      else if (i2 == 2)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeMiddleC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeMiddleGroup";
        }
      }
      else if (i2 == 3)
      {
        if (i1 != 0) {
          str1 = "PicStatisticsManagerPicPreviewSizeLargeC2C";
        } else {
          str1 = "PicStatisticsManagerPicPreviewSizeLargeGroup";
        }
      }
      else if (i1 != 0) {
        str1 = "PicStatisticsManagerPicPreivewSizeExtraLargeC2C";
      } else {
        str1 = "PicStatisticsManagerPicPreivewSizeExtraLargeGroup";
      }
    }
    label386:
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str2, l3).commit();
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    long l1;
    for (String str = a(paramInt2);; str = b(paramInt2))
    {
      l1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong(str, 0L) + 1L;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "addPredownloadMissPriority(): " + str + ", Count=" + l1);
      }
      if (Build.VERSION.SDK_INT < 9) {
        break;
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong(str, l1).commit();
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\pic\PicStatisticsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */