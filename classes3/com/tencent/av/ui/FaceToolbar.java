package com.tencent.av.ui;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.funchat.magicface.MagicfaceManagerForAV;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import gto;
import java.util.ArrayList;

public class FaceToolbar
  extends BaseToolbar
{
  public static String a;
  static String b;
  QAVPtvTemplateAdapter.IItemDownloadMgr jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr = new gto(this);
  QAVPtvTemplateAdapter jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "FaceToolbar";
  }
  
  public FaceToolbar()
  {
    this.jdField_a_of_type_Int = 2130903618;
  }
  
  public static String a(VideoController paramVideoController)
  {
    if (b == null) {
      a(paramVideoController);
    }
    return b;
  }
  
  public static boolean a(VideoController paramVideoController)
  {
    if (AudioHelper.b()) {}
    int i;
    int j;
    do
    {
      return true;
      if (!paramVideoController.a().f())
      {
        b = "";
        return false;
      }
      i = paramVideoController.c(paramVideoController.a().c);
      j = paramVideoController.b(paramVideoController.a().c);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "isEnable|  peerTerminalType = " + j + ", peerSharpVersion = " + i);
      }
      paramVideoController.a().N = true;
      String str = Build.MODEL.toLowerCase();
      if ((Build.VERSION.SDK_INT < 15) || (VcSystemInfo.c() < 1200L) || (VcSystemInfo.e() < 2) || (MagicfaceManagerForAV.a().a(str)))
      {
        b = "你的手机性能暂不支持发送互动表情。";
        paramVideoController.a().N = false;
        return false;
      }
      if (!paramVideoController.a().M)
      {
        b = "对方手机性能暂不支持接收互动表情。";
        return false;
      }
    } while (((i >= 46) && ((j == 4) || (j == 2) || (j == 3))) || ((j == 5) && (i >= 5509)));
    b = "对方QQ版本较低，提醒好友升级到最新版本即可体验。";
    return false;
  }
  
  ArrayList a()
  {
    Object localObject2 = MagicfaceManagerForAV.a().a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = new PtvTemplateManager.PtvTemplateInfo();
    ((PtvTemplateManager.PtvTemplateInfo)localObject2).id = "-1";
    ((ArrayList)localObject1).add(0, localObject2);
    return (ArrayList)localObject1;
  }
  
  protected void a(Context paramContext, QAVPtvTemplateAdapter.IEffectCallback paramIEffectCallback)
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299470));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
    ArrayList localArrayList = a();
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter = new QAVPtvTemplateAdapter(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramContext, localArrayList, this.jdField_a_of_type_ComTencentWidgetHorizontalListView);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(false);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(paramIEffectCallback);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter$IItemDownloadMgr);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetHorizontalListView == null) || (this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter == null)) {
      return;
    }
    paramArrayOfObject = a();
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.a(paramArrayOfObject);
    this.jdField_a_of_type_ComTencentAvUiQAVPtvTemplateAdapter.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\FaceToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */