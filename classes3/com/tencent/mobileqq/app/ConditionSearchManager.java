package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.data.AddressData;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceRespInfo;
import pvn;
import pvo;
import pvq;
import pvr;
import pvs;
import pvu;

public class ConditionSearchManager
  implements Manager
{
  private static final String A = "key_loc_country_code";
  private static final String B = "key_loc_prov_code";
  private static final String C = "key_loc_city_code";
  private static final String D = "key_loc_dist_code";
  private static final String E = "key_home_country_code";
  private static final String F = "key_home_prov_code";
  private static final String G = "key_home_city_code";
  private static final String H = "key_home_dist_code";
  private static final String I = "key_config_version";
  private static final String J = "temp_admin_regin_config";
  private static final String K = "key_last_checkup_time";
  public static final int a = 1;
  static final String jdField_a_of_type_JavaLangString = "ConditionSearch.Manager";
  public static final int[] a;
  public static final String[] a;
  public static final int b = 2;
  public static final String b = "不限";
  public static final int[] b;
  public static final String[] b;
  public static final int c = 3;
  private static final long c = 0L;
  public static final String c = "0";
  public static final String[] c;
  public static final int d = 0;
  public static final String d = "中国";
  public static final String[] d;
  public static final int e = 1;
  public static final String e = "1";
  public static final String[] e;
  public static final int f = 2;
  private static final long jdField_f_of_type_Long = 120000L;
  public static final String f = "-1";
  public static final int g = 0;
  public static final String g = "-";
  public static final int h = 1;
  public static final String h = "location_string";
  public static final int i = 2;
  public static final String i = "home_string";
  public static final int j = 0;
  public static final String j = "admin_region_config";
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  private static final String m = "key_first_run";
  public static final int n = 0;
  private static final String n = "key_first_select_location";
  public static final int o = 1;
  private static final String o = "key_first_select_home";
  private static final String p = "key_frist_run_in_5_2";
  private static final String q = "key_frist_run_add_contact";
  private static final String r = "key_sex_index";
  private static final String s = "key_age_index_v2_1";
  private static final String t = "key_age_index_v2_2";
  private static final String u = "key_xingzuo_index";
  private static final String v = "key_job_index";
  private static final String w = "key_cur_loc_country_code";
  private static final String x = "key_cur_loc_prov_code";
  private static final String y = "key_cur_loc_city_code";
  private static final String z = "key_cur_loc_dist_code";
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private ConditionSearchManager.IFirstLocationReqCancelListener jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new pvu(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AddressData jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData;
  public Object a;
  public LinkedList a;
  List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public volatile boolean a;
  public long b;
  LinkedList b;
  public List b;
  public volatile boolean b;
  public volatile boolean c;
  private volatile long d;
  public boolean d;
  private volatile long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private boolean jdField_f_of_type_Boolean;
  public String[] f;
  private volatile boolean g;
  public String[] g;
  private String[] h;
  private String[] i;
  private String[] j;
  public String k;
  private final String l = "condation_search_sp";
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public int u = 0;
  public int v = 0;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "不限", "男", "女" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "不限", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99" };
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "不限", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
    jdField_d_of_type_ArrayOfJavaLangString = new String[] { "不限", "计算机/互联网/通信", "生产/工艺/制造", "医疗/护理/制药", "金融/银行/投资/保险", "商业/服务业/个体经营", "文化/广告/传媒", "娱乐/艺术/表演", "律师/法务", "教育/培训", "公务员/行政/事业单位", "模特", "空姐", "学生", "其他职业" };
    jdField_e_of_type_ArrayOfJavaLangString = new String[] { "", "IT", "制造", "医疗", "金融", "商业", "文化", "艺术", "法律", "教育", "行政", "模特", "空姐", "学生", "" };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130841115, 2130840545, 2130840545, 2130840545, 2130840989, 2130840989, 2130841180, 2130841180, 2130840875, 2130840875, 2130840875, 2130841115, 2130841115, 2130841007, 2130841115 };
    jdField_b_of_type_ArrayOfInt = new int[] { -16777216, -11362561, -11362561, -11362561, -274353, -274353, -893603, -893603, -7745469, -7745469, -7745469, -8291118, -8291118, -16723548, -16777216 };
  }
  
  public ConditionSearchManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilLinkedList = null;
    this.jdField_b_of_type_JavaUtilLinkedList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("condation_search_sp", 0);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_first_run" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_config_version", 0L);
    this.jdField_e_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_last_checkup_time", 0L);
    this.jdField_f_of_type_Boolean = e();
  }
  
  public static final int a(String paramString)
  {
    int i1 = 0;
    int i3 = 0;
    int i2 = i3;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("0")) {
        i2 = i3;
      }
    }
    else {
      return i2;
    }
    int i4 = paramString.length();
    i2 = 0;
    for (;;)
    {
      i3 = i2;
      i2 = i1;
      if (i3 >= i4) {
        break;
      }
      int i5 = paramString.charAt(i3);
      i2 = i3 + 1;
      i1 = (i5 << (i4 - 1 - i3) * 8) + i1;
    }
  }
  
  private BaseAddress a(Map paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    Object localObject = new ArrayList(paramMap.size());
    ((List)localObject).addAll(paramMap.values());
    paramMap = ((List)localObject).iterator();
    while (paramMap.hasNext())
    {
      localObject = (BaseAddress)paramMap.next();
      if (((BaseAddress)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
        return (BaseAddress)localObject;
      }
    }
    return null;
  }
  
  public static final String a(long paramLong)
  {
    if (paramLong == 0L) {
      return "0";
    }
    StringBuilder localStringBuilder = new StringBuilder(6);
    while (paramLong != 0L) {
      try
      {
        localStringBuilder.append((char)(int)(paramLong % 256L));
        paramLong >>= 8;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ConditionSearch.Manager", 2, localOutOfMemoryError, new Object[0]);
        }
        return "0";
      }
    }
    return localOutOfMemoryError.reverse().toString();
  }
  
  private int e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "updateLocal | isParsing = " + this.jdField_g_of_type_Boolean);
    }
    if (this.jdField_g_of_type_Boolean) {
      return 0;
    }
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir(), "admin_region_config");
    if ((localFile == null) || (!localFile.exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "updateLocal | file is not exist");
      }
      this.jdField_d_of_type_Long = 0L;
      return 3;
    }
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new pvo(this, localFile));
    return 0;
  }
  
  private boolean e()
  {
    boolean bool = true;
    if (this.jdField_e_of_type_Boolean) {
      bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_frist_run_add_contact", true);
    }
    while ((this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_frist_run_in_5_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true)) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_age_index_v2_1" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_age_index_v2_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_job_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_xingzuo_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0) == 0) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0").equals("0")) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0").equals("0"))) {
      return bool;
    }
    return false;
  }
  
  public int a()
  {
    int i1;
    if (this.jdField_d_of_type_Long == 0L) {
      i1 = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "checkUpdate | result = " + i1);
      }
      return i1;
      if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null) {
        i1 = 2;
      } else {
        i1 = 0;
      }
    }
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 1)
    {
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("update | isCheckingUpdate = ").append(this.jdField_a_of_type_Boolean).append(" | interval is enough ");
        if (Math.abs(l1 - this.jdField_e_of_type_Long) >= 120000L)
        {
          bool = true;
          QLog.d("ConditionSearch.Manager", 2, bool + " | isNetAvaiable = " + NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        }
      }
      else
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label110;
        }
      }
    }
    label110:
    while (paramInt != 2)
    {
      long l1;
      for (;;)
      {
        return 0;
        boolean bool = false;
      }
      if (Math.abs(l1 - this.jdField_e_of_type_Long) < 120000L) {
        return 1;
      }
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        return 2;
      }
      Object localObject = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
      ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).f() });
      return 0;
    }
    return e();
  }
  
  public final long a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_last_checkup_time", this.jdField_e_of_type_Long).commit();
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "getConfigVersion | version = " + this.jdField_d_of_type_Long);
    }
    return this.jdField_d_of_type_Long;
  }
  
  public BaseAddress a(String paramString)
  {
    BaseAddress localBaseAddress = null;
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null) {
      localBaseAddress = (BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.get(paramString);
    }
    return localBaseAddress;
  }
  
  public String a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("location_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "不限");
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString("home_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "不限");
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    if (((paramInt1 > paramInt2) && (paramInt2 != 0)) || (paramInt1 < 0) || (paramInt2 < 0)) {
      return jdField_b_of_type_ArrayOfJavaLangString[0];
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      return jdField_b_of_type_ArrayOfJavaLangString[0];
    }
    if ((paramInt1 == 0) && (paramInt2 != 0)) {
      return jdField_b_of_type_ArrayOfJavaLangString[paramInt2] + "岁及以下";
    }
    if ((paramInt1 != 0) && (paramInt2 == 0)) {
      return jdField_b_of_type_ArrayOfJavaLangString[paramInt1] + "岁及以上";
    }
    if (paramInt1 == paramInt2) {
      return jdField_b_of_type_ArrayOfJavaLangString[paramInt1] + "岁";
    }
    return jdField_b_of_type_ArrayOfJavaLangString[paramInt1] + "-" + jdField_b_of_type_ArrayOfJavaLangString[paramInt2] + "岁";
  }
  
  public String a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    String str;
    do
    {
      for (;;)
      {
        return (String)localObject;
        str = paramString;
        try
        {
          String[] arrayOfString = paramString.split("-");
          str = paramString;
          if (arrayOfString[0].equals("中国"))
          {
            str = paramString;
            if (arrayOfString.length > 2)
            {
              paramString = arrayOfString[2];
              localObject = paramString;
              str = paramString;
              if (arrayOfString.length > 3)
              {
                str = paramString;
                return paramString + "-" + arrayOfString[3];
              }
            }
            else
            {
              localObject = paramString;
              str = paramString;
              if (arrayOfString.length > 1) {
                return arrayOfString[1];
              }
            }
          }
          else
          {
            localObject = paramString;
            str = paramString;
            if (arrayOfString.length > 2)
            {
              str = paramString;
              paramString = arrayOfString[(arrayOfString.length - 2)] + "-" + arrayOfString[(arrayOfString.length - 1)];
              return paramString;
            }
          }
        }
        catch (Exception paramString)
        {
          localObject = str;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConditionSearch.Manager", 2, "", paramString);
    return str;
  }
  
  public String a(String[] paramArrayOfString)
  {
    String str2 = b(paramArrayOfString);
    String str1 = str2;
    if ("1".equals(paramArrayOfString[0]))
    {
      str1 = str2;
      if (str2.split("-").length > 1) {
        str1 = str2.substring(str2.indexOf("-") + 1, str2.length());
      }
    }
    return str1;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null)
    {
      localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.size());
      localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.values());
      Collections.sort(localArrayList, new pvn(this));
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_job_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt).commit();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_age_index_v2_1" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt1).commit();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_age_index_v2_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt2).commit();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("location_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString).commit();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("home_string" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString).commit();
  }
  
  public void a(ConditionSearchManager.IFirstLocationReqCancelListener paramIFirstLocationReqCancelListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IFirstLocationReqCancelListener = paramIFirstLocationReqCancelListener;
  }
  
  public void a(Object paramObject)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramObject))
      {
        this.jdField_a_of_type_JavaUtilList.add(paramObject);
        this.jdField_b_of_type_Boolean = true;
        a(a());
        if ((paramObject instanceof ConditionSearchFriendActivity))
        {
          this.jdField_e_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_first_run" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
        }
      }
      return;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  public void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    int i1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onCheckupConfig | resp = ").append(paramGetResourceRespInfo).append(" | iResult = ");
      if (paramGetResourceRespInfo != null)
      {
        i1 = paramGetResourceRespInfo.iResult;
        QLog.d("ConditionSearch.Manager", 2, i1);
      }
    }
    else
    {
      if ((paramGetResourceRespInfo != null) && (paramGetResourceRespInfo.iResult == 0)) {
        break label77;
      }
      a(false);
    }
    label77:
    do
    {
      return;
      i1 = 64536;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "onCheckupConfig | local version = " + this.jdField_d_of_type_Long + " | server version = " + paramGetResourceRespInfo.uiNewVer);
      }
    } while (this.jdField_d_of_type_Long == paramGetResourceRespInfo.uiNewVer);
    Object localObject = paramGetResourceRespInfo.strResURL_big;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ConditionSearch.Manager", 2, "onCheckupConfig | url is null");
      }
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new pvq(this, (String)localObject, paramGetResourceRespInfo));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new pvr(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt4, int paramInt5, int paramInt6)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seachFriend | restart = ").append(paramBoolean).append(" | keyword = ").append(paramString).append(" | sexIndex = ").append(paramInt1).append(" | ageIndex1 = ").append(paramInt2).append(" | ageIndex2 = ").append(paramInt3).append(" | jobIndex = ").append(paramInt4).append(" | xingzuoIndex = ").append(paramInt5).append(" | searchFromMore = ").append(paramInt6);
      int i1;
      if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0))
      {
        localStringBuilder.append(" | locCodes = ");
        i1 = 0;
        while (i1 < paramArrayOfString1.length)
        {
          localStringBuilder.append(paramArrayOfString1[i1]).append("、");
          i1 += 1;
        }
      }
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
      {
        localStringBuilder.append(" | homeCodes = ");
        i1 = 0;
        while (i1 < paramArrayOfString2.length)
        {
          localStringBuilder.append(paramArrayOfString2[i1]).append("、");
          i1 += 1;
        }
      }
      QLog.d("ConditionSearch.Manager", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Long += 1L;
      this.k = paramString;
      this.p = paramInt1;
      this.q = paramInt2;
      this.r = paramInt3;
      this.jdField_f_of_type_ArrayOfJavaLangString = paramArrayOfString1;
      this.jdField_g_of_type_ArrayOfJavaLangString = paramArrayOfString2;
      this.s = paramInt4;
      this.t = paramInt5;
      this.u = -1;
      this.jdField_b_of_type_Long = 0L;
    }
    while (this.jdField_d_of_type_Boolean)
    {
      this.v = 0;
      this.jdField_b_of_type_JavaUtilList = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(this.jdField_a_of_type_Long, this.u + 1, this.jdField_b_of_type_Long, this.k, this.p, this.q, this.r, this.jdField_f_of_type_ArrayOfJavaLangString, this.jdField_g_of_type_ArrayOfJavaLangString, this.s, this.t, paramInt6);
      return;
    }
    throw new RuntimeException("No more elements");
  }
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_b_of_type_JavaUtilLinkedList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext()) {
        ((ConditionSearchManager.ISearchListener)localIterator.next()).a(paramBoolean1, paramList, paramBoolean2, paramInt);
      }
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.h = ((String[])paramArrayOfString.clone());
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_cur_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.h[0]).putString("key_cur_loc_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.h[1]).putString("key_cur_loc_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.h[2]).putString("key_cur_loc_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.h[3]).commit();
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public int[] a()
  {
    Card localCard;
    int i1;
    int i2;
    if (this.jdField_f_of_type_Boolean)
    {
      localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localCard == null) {
        break label353;
      }
      if ((localCard.age <= 5) || (localCard.age >= 60))
      {
        i1 = 0;
        i2 = 0;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_age_index_v2_1" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i2).commit();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_age_index_v2_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).commit();
      }
    }
    for (;;)
    {
      return new int[] { i2, i1 };
      if ((localCard.age >= 6) && (localCard.age <= 11))
      {
        i1 = 11;
        i2 = 6;
        break;
      }
      if ((localCard.age >= 12) && (localCard.age <= 17))
      {
        i1 = 17;
        i2 = 12;
        break;
      }
      if ((localCard.age >= 18) && (localCard.age <= 21))
      {
        i1 = 21;
        i2 = 18;
        break;
      }
      if (localCard.shGender != 0)
      {
        i2 = localCard.age - 5;
        i1 = localCard.age + 10;
        break;
      }
      i1 = localCard.age + 5;
      i2 = 18;
      break;
      i2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_age_index_v2_1" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      i1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_age_index_v2_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
      continue;
      label353:
      i1 = 0;
      i2 = 0;
    }
  }
  
  public String[] a()
  {
    if (this.h == null)
    {
      this.h = new String[4];
      this.h[0] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_cur_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.h[1] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_cur_loc_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.h[2] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_cur_loc_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.h[3] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_cur_loc_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
    }
    return this.h;
  }
  
  public String[] a(String paramString)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "不限";
    arrayOfString[1] = "不限";
    if ((!TextUtils.isEmpty(paramString)) && (!"不限".equals(paramString)))
    {
      int i1 = paramString.indexOf("-");
      if (i1 != -1)
      {
        arrayOfString[0] = paramString.substring(0, i1);
        arrayOfString[1] = paramString.substring(i1 + 1);
      }
    }
    else
    {
      return arrayOfString;
    }
    arrayOfString[0] = paramString;
    return arrayOfString;
  }
  
  public String[] a(String paramString1, String paramString2, String paramString3)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "0";
    arrayOfString[1] = "0";
    arrayOfString[2] = "0";
    arrayOfString[3] = "0";
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "parseAddressToCodeArray | address data = null");
      }
    }
    do
    {
      do
      {
        BaseAddress localBaseAddress;
        do
        {
          do
          {
            return arrayOfString;
          } while (TextUtils.isEmpty(paramString1));
          localBaseAddress = a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a, paramString1);
        } while (localBaseAddress == null);
        arrayOfString[0] = localBaseAddress.b;
        paramString1 = localBaseAddress;
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = a(localBaseAddress.jdField_a_of_type_JavaUtilLinkedHashMap, paramString2);
          paramString1 = paramString2;
          if (paramString2 != null)
          {
            arrayOfString[1] = paramString2.b;
            paramString1 = paramString2;
          }
        }
      } while ((paramString1 == null) || (TextUtils.isEmpty(paramString3)));
      paramString1 = a(paramString1.jdField_a_of_type_JavaUtilLinkedHashMap, paramString3);
    } while (paramString1 == null);
    arrayOfString[2] = paramString1.b;
    return arrayOfString;
  }
  
  public String[] a(String[] paramArrayOfString)
  {
    int i1 = 1;
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 4) || ("-1".equals(paramArrayOfString[0]))) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfString = new StringBuilder().append("praseCodeArrayToAddress addressData == null is ");
        if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null) {
          break label80;
        }
      }
      label80:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ConditionSearch.Manager", 2, bool);
        return null;
      }
    }
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if ("-1".equals(paramArrayOfString[0])) {
      return arrayOfString;
    }
    Object localObject1 = (BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.get(paramArrayOfString[0]);
    if (localObject1 == null) {
      return arrayOfString;
    }
    arrayOfString[0] = ((BaseAddress)localObject1).jdField_a_of_type_JavaLangString;
    while (i1 < 4)
    {
      Object localObject2 = localObject1;
      if (!"0".equals(paramArrayOfString[i1]))
      {
        localObject2 = (BaseAddress)((BaseAddress)localObject1).jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayOfString[i1]);
        if (localObject2 == null) {
          break;
        }
        arrayOfString[i1] = ((BaseAddress)localObject2).jdField_a_of_type_JavaLangString;
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    return arrayOfString;
  }
  
  public int b()
  {
    int i1 = 0;
    if (!this.jdField_f_of_type_Boolean) {
      i1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_job_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    }
    return i1;
  }
  
  public String b(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("中国"))
    {
      String[] arrayOfString = StringUtil.a(paramString, '-');
      str = paramString;
      if (arrayOfString.length >= 2)
      {
        paramString = new StringBuilder();
        int i1 = 1;
        while (i1 < arrayOfString.length)
        {
          paramString.append(arrayOfString[i1]);
          if (i1 != arrayOfString.length - 1) {
            paramString.append("-");
          }
          i1 += 1;
        }
        str = paramString.toString();
      }
    }
    return str;
  }
  
  public String b(String[] paramArrayOfString)
  {
    int i1 = 1;
    boolean bool = false;
    if ((paramArrayOfString == null) || (paramArrayOfString.length != 4) || ("-1".equals(paramArrayOfString[0]))) {
      return "0";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null)
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfString = new StringBuilder().append("praseCodeArrayToAddress addressData == null is ");
        if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData == null) {
          bool = true;
        }
        QLog.d("ConditionSearch.Manager", 2, bool);
      }
      return "不限";
    }
    if ("-1".equals(paramArrayOfString[0])) {
      return "不限";
    }
    Object localObject1 = (BaseAddress)this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a.get(paramArrayOfString[0]);
    if (localObject1 == null) {
      return "不限";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((BaseAddress)localObject1).jdField_a_of_type_JavaLangString);
    while (i1 < 4)
    {
      Object localObject2 = localObject1;
      if (!"0".equals(paramArrayOfString[i1]))
      {
        localObject2 = (BaseAddress)((BaseAddress)localObject1).jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayOfString[i1]);
        if (localObject2 == null) {
          break;
        }
        localStringBuilder.append("-").append(((BaseAddress)localObject2).jdField_a_of_type_JavaLangString);
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    return localStringBuilder.toString();
  }
  
  public void b()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_frist_run_in_5_2" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_frist_run_add_contact" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_xingzuo_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt).commit();
  }
  
  public void b(Object paramObject)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramObject);
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
      }
      return;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  public void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.i = ((String[])paramArrayOfString.clone());
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.i[0]).putString("key_loc_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.i[1]).putString("key_loc_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.i[2]).putString("key_loc_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.i[3]).commit();
  }
  
  public final boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public String[] b()
  {
    if (this.i == null)
    {
      this.i = new String[4];
      this.i[0] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.i[1] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.i[2] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.i[3] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_loc_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
    }
    return this.i;
  }
  
  public int c()
  {
    int i1 = 0;
    if (!this.jdField_f_of_type_Boolean) {
      i1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_xingzuo_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    }
    return i1;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = true;
    a(this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new pvs(this));
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramInt).commit();
  }
  
  public void c(Object paramObject)
  {
    if ((paramObject instanceof ConditionSearchManager.IConfigListener))
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
        this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.contains(paramObject)) {}
    }
    do
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add((ConditionSearchManager.IConfigListener)paramObject);
      do
      {
        return;
      } while (!(paramObject instanceof ConditionSearchManager.ISearchListener));
      if (this.jdField_b_of_type_JavaUtilLinkedList == null) {
        this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
      }
    } while (this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject));
    this.jdField_b_of_type_JavaUtilLinkedList.add((ConditionSearchManager.ISearchListener)paramObject);
  }
  
  public void c(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    if (paramArrayOfString.length != 4) {
      throw new IllegalArgumentException("Error size " + paramArrayOfString.length);
    }
    this.j = ((String[])paramArrayOfString.clone());
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_home_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.j[0]).putString("key_home_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.j[1]).putString("key_home_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.j[2]).putString("key_home_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.j[3]).commit();
  }
  
  public boolean c()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_first_select_location" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    if (bool) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_first_select_location" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
    }
    return bool;
  }
  
  public String[] c()
  {
    if (this.j == null)
    {
      this.j = new String[4];
      this.j[0] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_country_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.j[1] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_prov_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.j[2] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_city_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
      this.j[3] = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_home_dist_code" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "0");
    }
    return this.j;
  }
  
  public int d()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localCard == null) {
        break label132;
      }
      if (localCard.shGender != 0) {
        break label127;
      }
    }
    label127:
    for (int i1 = 2;; i1 = 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), i1).commit();
      return i1;
      return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_sex_index" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
    }
    label132:
    return 0;
  }
  
  public void d(Object paramObject)
  {
    if ((paramObject instanceof ConditionSearchManager.IConfigListener)) {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramObject);
      }
    }
    while ((!(paramObject instanceof ConditionSearchManager.ISearchListener)) || (this.jdField_b_of_type_JavaUtilLinkedList == null)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilLinkedList.remove(paramObject);
  }
  
  public boolean d()
  {
    boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_first_select_home" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), true);
    if (bool) {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("key_first_select_home" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), false).commit();
    }
    return bool;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData.a();
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchDataAddressData = null;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\ConditionSearchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */