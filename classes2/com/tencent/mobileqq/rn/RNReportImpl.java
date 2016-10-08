package com.tencent.mobileqq.rn;

import android.util.SparseArray;
import com.tencent.bitapp.report.IRNReport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;
import java.util.concurrent.ConcurrentHashMap;
import uka;
import ukb;
import ukc;

public class RNReportImpl
  implements IRNReport
{
  static final String jdField_a_of_type_JavaLangString = "RNReportImpl";
  public static final String b = "RNINIT_";
  public final SparseArray a;
  final ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  public final SparseArray b;
  public final String c;
  
  public RNReportImpl(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.c = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(8);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, "actRNStageBundle");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(21, "actRNStageBSM");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(22, "actRNStageMSM");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, "actRNStageDetail");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, "actRNStageNet");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, "actRNStageUnzip");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, "actRNInit");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(7, "actRNCreateContext");
    this.b = new SparseArray(17);
    this.b.put(20, "param_b_cache");
    this.b.put(21, "param_b_bsm");
    this.b.put(210, "param_bsm_init");
    this.b.put(211, "param_bsm_cache");
    this.b.put(212, "param_bsm_file");
    this.b.put(213, "param_bsm_module");
    this.b.put(214, "param_bsm_combin");
    this.b.put(215, "param_bsm_suc");
    this.b.put(220, "param_msm_init");
    this.b.put(221, "param_msm_cache");
    this.b.put(222, "param_msm_depenfile");
    this.b.put(223, "param_msm_file");
    this.b.put(224, "param_msm_detail");
    this.b.put(225, "param_msm_net");
    this.b.put(226, "param_msm_unzip");
    this.b.put(227, "param_msm_denpen");
    this.b.put(228, "param_msm_suc");
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    SparseArray localSparseArray;
    do
    {
      return;
      localSparseArray = (SparseArray)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localSparseArray != null) {
        break;
      }
    } while (!NearbyUtils.a());
    NearbyUtils.a("RNReportImpl", "realReport", new Object[] { "stageSparseArray is null" });
    return;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    ThreadManager.a(new uka(this, localSparseArray, paramString), 5, null, false);
  }
  
  public void addStageFlag(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a("RNReportImpl", "addStageFlag", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    if (paramString == null) {}
    do
    {
      do
      {
        return;
        paramString = (SparseArray)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if (paramString == null) {
          break;
        }
        paramString = (ukb)paramString.get(paramInt1);
        if (paramString != null)
        {
          switch (paramInt2)
          {
          default: 
            return;
          case 0: 
            paramString.b = paramInt3;
            return;
          case 2: 
            paramString.d = paramInt3;
            return;
          case 3: 
            paramString.e = paramInt3;
            return;
          case 1: 
            paramString.c = paramInt3;
            return;
          }
          paramString.f = paramInt3;
          return;
        }
      } while (!NearbyUtils.b());
      NearbyUtils.a("RNReportImpl", new Object[] { "addStageFlag", "stage obj is null" });
      return;
    } while (!NearbyUtils.b());
    NearbyUtils.a("RNReportImpl", new Object[] { "addStageFlag", "stageSparseArray is null" });
  }
  
  public void reportStageEnd(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a("RNReportImpl", "reportStageEnd", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    if (paramString == null) {}
    label277:
    label303:
    do
    {
      do
      {
        do
        {
          SparseArray localSparseArray;
          do
          {
            do
            {
              do
              {
                return;
                localSparseArray = (SparseArray)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
                if (localSparseArray == null) {
                  break label303;
                }
                ukb localukb = (ukb)localSparseArray.get(paramInt1);
                if (localukb == null) {
                  break label277;
                }
                localukb.a(paramInt2, paramInt3);
                if (NearbyUtils.a())
                {
                  String str2 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(localukb.g);
                  String str1;
                  if (str2 != null)
                  {
                    str1 = str2;
                    if (str2.length() != 0) {}
                  }
                  else
                  {
                    str1 = (String)this.b.get(localukb.g);
                  }
                  NearbyUtils.a("RNReportImpl", "endOfStep", new Object[] { str1, localukb });
                }
                if (paramInt1 == 2)
                {
                  a(paramString);
                  return;
                }
                if (paramInt1 != 21) {
                  break;
                }
              } while (localSparseArray.get(2) != null);
              a(paramString);
              return;
              if (paramInt1 != 22) {
                break;
              }
            } while (localSparseArray.get(21) != null);
            a(paramString);
            return;
            if ((paramInt1 != 3) && (paramInt1 != 4) && (paramInt1 != 5)) {
              break;
            }
          } while (localSparseArray.get(22) != null);
          a(paramString);
          return;
          if (paramInt1 == 7)
          {
            a(paramString);
            return;
          }
        } while (paramInt1 != 6);
        a(paramString);
        return;
      } while (!NearbyUtils.b());
      NearbyUtils.a("RNReportImpl", new Object[] { "reportStageEnd", "stage obj is null" });
      return;
    } while (!NearbyUtils.b());
    NearbyUtils.a("RNReportImpl", new Object[] { "reportStageEnd", "stageSparseArray is null" });
  }
  
  public void reportStageStart(String paramString, int paramInt)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a("RNReportImpl", "reportStageStart", new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (paramString == null) {}
    do
    {
      return;
      ukb localukb = new ukb(paramInt);
      SparseArray localSparseArray2 = (SparseArray)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      SparseArray localSparseArray1 = localSparseArray2;
      if (localSparseArray2 == null)
      {
        localSparseArray1 = new SparseArray();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localSparseArray1);
      }
      if (localSparseArray1 != null)
      {
        localSparseArray1.put(paramInt, localukb);
        return;
      }
    } while (!NearbyUtils.b());
    NearbyUtils.a("RNReportImpl", new Object[] { "reportStageStart", "stageSparseArray is null" });
  }
  
  public void reportStageStepEnd(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a("RNReportImpl", "reportStageStepEnd", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    if (paramString == null) {}
    label198:
    label224:
    do
    {
      do
      {
        do
        {
          ukb localukb;
          do
          {
            return;
            paramString = (SparseArray)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
            if (paramString == null) {
              break label224;
            }
            localukb = (ukb)paramString.get(paramInt1);
            if (localukb == null) {
              break label198;
            }
            paramString = localukb.a(paramInt2);
            if (paramString == null) {
              break;
            }
            paramString.a(paramInt3);
          } while (!NearbyUtils.a());
          String str = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(localukb.g);
          if (str != null)
          {
            paramString = str;
            if (str.length() != 0) {}
          }
          else
          {
            paramString = (String)this.b.get(localukb.g);
          }
          NearbyUtils.a("RNReportImpl", "endOfStep", new Object[] { paramString, localukb });
          return;
        } while (!NearbyUtils.b());
        NearbyUtils.a("RNReportImpl", new Object[] { "reportStageStepEnd", "step obj is null" });
        return;
      } while (!NearbyUtils.b());
      NearbyUtils.a("RNReportImpl", new Object[] { "reportStageStepEnd", "stage obj is null" });
      return;
    } while (!NearbyUtils.b());
    NearbyUtils.a("RNReportImpl", new Object[] { "reportStageStepEnd", "stageSparseArray is null" });
  }
  
  public void reportStageStepStart(String paramString, int paramInt1, int paramInt2)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a("RNReportImpl", "reportStageStepStart", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    if (paramString == null) {}
    do
    {
      do
      {
        return;
        paramString = (SparseArray)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        if (paramString == null) {
          break;
        }
        paramString = (ukb)paramString.get(paramInt1);
        if (paramString != null)
        {
          paramString.a(new ukc(paramInt2));
          return;
        }
      } while (!NearbyUtils.b());
      NearbyUtils.a("RNReportImpl", new Object[] { "reportStateEnd", "stage obj is null" });
      return;
    } while (!NearbyUtils.b());
    NearbyUtils.a("RNReportImpl", new Object[] { "reportStageStepStart", "stageSparseArray is null" });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\rn\RNReportImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */