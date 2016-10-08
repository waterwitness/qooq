package cooperation.troop_homework.jsp;

import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import java.io.File;
import java.util.HashMap;
import ytq;
import ytr;
import yts;
import ytt;
import ytu;

public class TroopHWFileDownloadManager
{
  public static final String a;
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new ytu(this);
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
  private TMAssistantDownloadSettingClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadSettingClient;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private String jdField_b_of_type_JavaLangString;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TroopHWFileDownloadManager.class.getName();
  }
  
  public TroopHWFileDownloadManager(Context paramContext)
  {
    this.jdField_b_of_type_JavaLangString = (AppConstants.bh + "/tencent/TMAssistantSDK/Download/" + paramContext.getPackageName() + "/");
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(paramContext.getApplicationContext()).getDownloadSDKClient(jdField_a_of_type_JavaLangString + Process.myPid());
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadSettingClient = TMAssistantDownloadManager.getInstance(paramContext).getDownloadSDKSettingClient();
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
  }
  
  public void a(String paramString)
  {
    ThreadManager.a(new ytr(this, paramString), 5, null, true);
  }
  
  public void a(String paramString1, String paramString2, TroopHWFileDownloadManager.OnDownloadStateListener paramOnDownloadStateListener)
  {
    String str = paramString2.substring(paramString2.lastIndexOf("/") + 1);
    File localFile = new File(paramString2);
    if (localFile.exists())
    {
      if (paramOnDownloadStateListener != null)
      {
        paramOnDownloadStateListener.a(paramString1, localFile.length(), localFile.length());
        paramOnDownloadStateListener.a(paramString1, 3, 0, null, paramString2);
      }
      return;
    }
    if (!this.jdField_b_of_type_JavaUtilHashMap.containsKey(paramString1))
    {
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString1, paramOnDownloadStateListener);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
    }
    ThreadManager.a(new ytq(this, paramString1, str), 5, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.a(new ytt(this, paramBoolean), 5, null, true);
  }
  
  public void b(String paramString)
  {
    ThreadManager.a(new yts(this, paramString), 5, null, true);
    this.jdField_b_of_type_JavaUtilHashMap.remove(paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\troop_homework\jsp\TroopHWFileDownloadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */