package com.tencent.bitapp.report;

public class RNReport
{
  public static final int BSM_CACHE = 211;
  public static final int BSM_COMBIN = 214;
  public static final int BSM_FILE = 212;
  public static final int BSM_INIT = 210;
  public static final int BSM_MODULE = 213;
  public static final int BSM_SUC = 215;
  public static final int BUNDLE_BSM = 21;
  public static final int BUNDLE_CACHE = 20;
  public static final int BUNDLE_MSM = 22;
  public static final int FLAG_BS_NEED_UPDATE = 2;
  public static final int FLAG_BUNDLE_IN_CACHE = 0;
  public static final int FLAG_CONTEXT_READY = 4;
  public static final int FLAG_DENPEN_EXIST = 3;
  public static final int FLAG_MODULE_IN_FILE = 1;
  public static final String KEY_CREATE_CONTEXT = "key_create_context";
  public static final int MSM_CACHE = 221;
  public static final int MSM_DENPEN = 227;
  public static final int MSM_DETAIL = 224;
  public static final int MSM_FILE = 223;
  public static final int MSM_INIT = 220;
  public static final int MSM_LOAD_DEPEN_FILE = 222;
  public static final int MSM_NET = 225;
  public static final int MSM_SUC = 228;
  public static final int MSM_UNZIP = 226;
  public static final int STAGE_BUNDLE = 2;
  public static final int STAGE_CREATECONTEXT = 7;
  public static final int STAGE_DETAIL = 3;
  public static final int STAGE_NET = 4;
  public static final int STAGE_RNINIT = 6;
  public static final int STAGE_SO = 1;
  public static final int STAGE_UNZIP = 5;
  public static String sLastKey = null;
  static IRNReport sReport = null;
  
  public static void addStageFlag(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (sReport != null) {
      sReport.addStageFlag(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public static void reportStageEnd(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (sReport != null) {
      sReport.reportStageEnd(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public static void reportStageStart(String paramString, int paramInt)
  {
    if (sReport != null) {
      sReport.reportStageStart(paramString, paramInt);
    }
  }
  
  public static void reportStageStepEnd(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (sReport != null) {
      sReport.reportStageStepEnd(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public static void reportStageStepStart(String paramString, int paramInt1, int paramInt2)
  {
    if (sReport != null) {
      sReport.reportStageStepStart(paramString, paramInt1, paramInt2);
    }
  }
  
  public static void setRNReportImpl(IRNReport paramIRNReport)
  {
    sReport = paramIRNReport;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\report\RNReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */