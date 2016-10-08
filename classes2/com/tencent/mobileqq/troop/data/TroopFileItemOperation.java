package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.DownloadFileConfig;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.UUID;
import vmq;
import vmr;
import vms;
import vmt;
import vmu;
import vmv;
import vmw;
import vmx;
import vmy;
import vmz;
import vna;
import vnb;
import vnc;

public class TroopFileItemOperation
{
  public static final long c = 3145728L;
  public Activity a;
  public QQAppInterface a;
  public long b;
  
  public TroopFileItemOperation(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private int a()
  {
    return a(true);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_b_of_type_Long);
    }
    return TroopFileUtils.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, long paramLong1, TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, long paramLong2, int paramInt)
  {
    FileInfo localFileInfo = new FileInfo();
    if (!FileUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(paramQQAppInterface, paramLong1).b();
    }
    switch (paramTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      Object localObject = "";
      if (!TextUtils.isEmpty(paramTroopFileStatusInfo.g)) {
        localObject = paramTroopFileStatusInfo.g;
      }
      TroopFileManager.a(paramQQAppInterface, paramLong1).a(paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      localFileInfo.d((String)localObject);
      localFileInfo.e(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
      localFileInfo.a(paramTroopFileStatusInfo.jdField_b_of_type_Long);
      TroopFileStatusInfo localTroopFileStatusInfo = new TroopFileStatusInfo();
      localTroopFileStatusInfo.g = ((String)localObject);
      localTroopFileStatusInfo.jdField_a_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
      localTroopFileStatusInfo.jdField_b_of_type_Long = paramTroopFileStatusInfo.jdField_b_of_type_Long;
      localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID = paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID;
      localTroopFileStatusInfo.jdField_a_of_type_Long = paramLong1;
      localTroopFileStatusInfo.jdField_e_of_type_Int = paramTroopFileStatusInfo.jdField_e_of_type_Int;
      localTroopFileStatusInfo.jdField_e_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
      localTroopFileStatusInfo.f = paramTroopFileStatusInfo.f;
      localTroopFileStatusInfo.jdField_b_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
      localTroopFileStatusInfo.jdField_c_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
      localTroopFileStatusInfo.d = paramTroopFileStatusInfo.d;
      localTroopFileStatusInfo.jdField_b_of_type_Int = paramTroopFileStatusInfo.jdField_b_of_type_Int;
      localObject = FileManagerUtil.a(localTroopFileStatusInfo);
      ((FileManagerEntity)localObject).selfUin = paramString;
      ((FileManagerEntity)localObject).lastTime = paramLong2;
      ((FileManagerEntity)localObject).bSend = paramQQAppInterface.getAccount().equals(((FileManagerEntity)localObject).selfUin);
      paramTroopFileStatusInfo = new ForwardFileInfo();
      paramTroopFileStatusInfo.b(((FileManagerEntity)localObject).nSessionId);
      paramTroopFileStatusInfo.d(4);
      paramTroopFileStatusInfo.b(10006);
      paramTroopFileStatusInfo.a(localFileInfo.d());
      paramTroopFileStatusInfo.d(localFileInfo.e());
      paramTroopFileStatusInfo.d(localFileInfo.a());
      paramTroopFileStatusInfo.a(paramLong1);
      if (!(paramActivity instanceof BasePluginActivity)) {
        break;
      }
    }
    for (paramQQAppInterface = ((BasePluginActivity)paramActivity).getOutActivity();; paramQQAppInterface = paramActivity)
    {
      paramQQAppInterface = new Intent(paramQQAppInterface, TroopFileDetailBrowserActivity.class);
      paramQQAppInterface.putExtra("fileinfo", paramTroopFileStatusInfo);
      paramQQAppInterface.putExtra("removemementity", true);
      paramQQAppInterface.putExtra("forward_from_troop_file", true);
      paramQQAppInterface.putExtra("not_forward", true);
      paramQQAppInterface.putExtra("last_time", paramLong2);
      paramQQAppInterface.putExtra("from_type_troop", paramInt);
      paramActivity.startActivityForResult(paramQQAppInterface, 102);
      return;
      paramQQAppInterface = "";
      paramInt = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1;
      if (paramInt < paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.length()) {
        paramQQAppInterface = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.substring(paramInt, paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString.length() - 1);
      }
      TroopFileError.a(paramActivity, b(2131364204, new Object[] { TroopFileUtils.a(paramQQAppInterface) }));
      return;
    }
  }
  
  private static String b(int paramInt)
  {
    return BaseApplicationImpl.getContext().getResources().getString(paramInt);
  }
  
  private static String b(int paramInt, Object... paramVarArgs)
  {
    return String.format(b(paramInt), paramVarArgs);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.TroopUin, paramFileManagerEntity.zipFilePath, paramFileManagerEntity.busId, new vmx(this, paramFileManagerEntity));
  }
  
  protected TroopFileInfo a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof TroopFileInfo))) {
      return null;
    }
    return (TroopFileInfo)paramView;
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      vmw localvmw = new vmw(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131364185, new Object[] { TroopFileUtils.a(paramFileManagerEntity.fileName), TroopFileUtils.a(paramFileManagerEntity.fileSize) });
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131364178), paramFileManagerEntity, 2131367262, 2131367260, localvmw, localvmw).show();
      return;
    }
    b(paramFileManagerEntity);
  }
  
  public void a(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new vmz(this, paramTroopFileInfo);
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131364179), b(2131364191), 2131367262, 2131367263, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localQQCustomDialog.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localQQCustomDialog.getMessageTextView().setLayoutParams(paramString1);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131367263), new vmu(this, paramTroopFileInfo));
    localQQCustomDialog.show();
  }
  
  public void a(TroopFileStatusInfo paramTroopFileStatusInfo, String paramString, long paramLong, int paramInt)
  {
    a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long, paramTroopFileStatusInfo, paramString, paramLong, paramInt);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    Object localObject = HWTroopUtils.a(paramString2);
    localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a((String)localObject);
    if ((i == 1) && (paramLong > ((TroopManager.DownloadFileConfig)localObject).jdField_b_of_type_Int))
    {
      paramString1 = new vmv(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
      paramString2 = b(2131364188, new Object[] { TroopFileUtils.a(paramString2), TroopFileUtils.a(paramLong) });
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131364178), paramString2, 2131367262, 2131364138, paramString1, paramString1).show();
      return;
    }
    localTroopFileTransferManager.a(paramString1, paramString2, paramLong, paramInt);
  }
  
  public void a(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    if (i == 1)
    {
      vmq localvmq = new vmq(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131364186, new Object[] { TroopFileUtils.a(paramUUID.g), TroopFileUtils.a(paramUUID.jdField_b_of_type_Long) });; paramUUID = b(2131364187))
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131364178), paramUUID, 2131367262, 2131364141, localvmq, localvmq).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    paramTroopFileInfo = new vna(this, paramTroopFileInfo);
    DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131364180), b(2131364192), 2131367262, 2131367263, paramTroopFileInfo, paramTroopFileInfo).show();
  }
  
  public void b(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    if (i == 1)
    {
      Object localObject = localTroopFileTransferManager.a(paramUUID);
      long l = 3145729L;
      if (localObject != null) {
        l = ((TroopFileStatusInfo)localObject).jdField_b_of_type_Long;
      }
      for (localObject = b(2131364189, new Object[] { TroopFileUtils.a(((TroopFileStatusInfo)localObject).g), TroopFileUtils.a(((TroopFileStatusInfo)localObject).jdField_b_of_type_Long) }); l > 3145728L; localObject = b(2131364190))
      {
        paramUUID = new vmy(this, localTroopFileTransferManager, paramUUID);
        DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131364178), (String)localObject, 2131367262, 2131364142, paramUUID, paramUUID).show();
        return;
      }
      localTroopFileTransferManager.e(paramUUID);
      return;
    }
    localTroopFileTransferManager.e(paramUUID);
  }
  
  public void c(TroopFileInfo paramTroopFileInfo)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    ThreadManager.a(new vnb(this, localTroopFileTransferManager), 8, new vnc(this, localTroopFileTransferManager, paramTroopFileInfo), false);
  }
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    int i = a(false);
    vmr localvmr = new vmr(this, paramTroopFileInfo);
    if (i == 1) {}
    for (paramTroopFileInfo = b(2131364189, new Object[] { TroopFileUtils.a(paramTroopFileInfo.jdField_c_of_type_JavaLangString), paramTroopFileInfo.a() });; paramTroopFileInfo = b(2131364194, new Object[] { TroopFileUtils.a(paramTroopFileInfo.jdField_c_of_type_JavaLangString) }))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131364182), paramTroopFileInfo, 2131367262, 2131364142, localvmr, localvmr).show();
      return;
    }
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    boolean bool = false;
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2131230804);
    if (paramTroopFileInfo.jdField_e_of_type_Int == 11)
    {
      localActionSheet.a(arrayOfString[0], 1);
      bool = true;
    }
    if ((TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramTroopFileInfo.c()))) {
      localActionSheet.a(arrayOfString[1], 1);
    }
    localActionSheet.a(new vms(this, bool, paramTroopFileInfo, localActionSheet));
    localActionSheet.d(2131367262);
    localActionSheet.show();
  }
  
  public void f(TroopFileInfo paramTroopFileInfo)
  {
    TroopFileStatusInfo localTroopFileStatusInfo2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long).a(paramTroopFileInfo.jdField_b_of_type_JavaLangString);
    TroopFileStatusInfo localTroopFileStatusInfo1 = localTroopFileStatusInfo2;
    if (localTroopFileStatusInfo2 == null) {
      localTroopFileStatusInfo1 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long, paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID.toString(), paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo.jdField_c_of_type_JavaLangString, paramTroopFileInfo.jdField_a_of_type_Long, paramTroopFileInfo.jdField_a_of_type_Int);
    }
    if ("/".equals(paramTroopFileInfo.f)) {}
    for (int i = 0;; i = 1)
    {
      a(localTroopFileStatusInfo1, String.valueOf(paramTroopFileInfo.jdField_b_of_type_Long), paramTroopFileInfo.jdField_c_of_type_Int, i);
      return;
    }
  }
  
  public void g(TroopFileInfo paramTroopFileInfo)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131364200);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131364217), new Object[] { TroopFileUtils.a(paramTroopFileInfo.jdField_c_of_type_JavaLangString) });
    QQCustomDialog localQQCustomDialog = DialogUtil.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(str1).setMessage(str2);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131367263), new vmt(this, paramTroopFileInfo));
    localQQCustomDialog.show();
  }
  
  public void h(TroopFileInfo paramTroopFileInfo)
  {
    if (a() != 0)
    {
      TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long).a(paramTroopFileInfo);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_b_of_type_Long + "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\TroopFileItemOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */