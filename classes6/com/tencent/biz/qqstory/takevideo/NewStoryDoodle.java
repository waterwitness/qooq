package com.tencent.biz.qqstory.takevideo;

import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.model.DoodleEmojiManager.POIPostersRequestCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.DoodleEmojiItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.ImageLoader;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import com.tencent.biz.qqstory.takevideo.music.MusicComposeDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import iuo;
import iup;
import iuq;
import iur;
import ius;
import iut;
import iuu;
import iuv;
import iuw;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NewStoryDoodle
  extends NewStoryPart
  implements DoodleLayout.DoodleEventListener, IEventReceiver
{
  public static final int a = 720;
  protected static final String a = "Q.qqstory.record.StoryDoodle";
  public static final int b = 1280;
  public static final String b = QQStoryConstant.q + "doodle_generate";
  protected long a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  public DoodleEmojiManager.POIPostersRequestCallback a;
  NewStoryPoiList.SelectLocationCallback jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiList$SelectLocationCallback = new iuo(this);
  private DoodleLayout jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  private FaceListPage.FacePackagePageEventListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener = new iur(this);
  private LocationFacePackage jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage;
  iuu jdField_a_of_type_Iuu;
  iuv jdField_a_of_type_Iuv;
  private iuw jdField_a_of_type_Iuw;
  protected byte[] a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public NewStoryDoodle()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelDoodleEmojiManager$POIPostersRequestCallback = new iuq(this);
  }
  
  private Collection a(boolean paramBoolean)
  {
    Object localObject = ((DoodleEmojiManager)SuperManager.a(8)).a(paramBoolean);
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DoodleEmojiItem localDoodleEmojiItem = (DoodleEmojiItem)((Iterator)localObject).next();
      SLog.b("Q.qqstory.record.StoryDoodle", "add doodle emoji item = " + localDoodleEmojiItem);
      NormalFacePackage localNormalFacePackage = new NormalFacePackage(localDoodleEmojiItem.a);
      localNormalFacePackage.b = localDoodleEmojiItem.d;
      localNormalFacePackage.c = localDoodleEmojiItem.b;
      localNormalFacePackage.d = localDoodleEmojiItem.c;
      localNormalFacePackage.g = localDoodleEmojiItem.a();
      localArrayList.add(localNormalFacePackage);
    }
    if (localArrayList.size() > 0)
    {
      localObject = DoodleEmojiManager.a((StoryConfigManager)SuperManager.a(10), "0");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label211;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.c = ((String)localObject);
    }
    for (;;)
    {
      localArrayList.add(1, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage);
      SLog.b("Q.qqstory.record.StoryDoodle", "getDoodleFacePackages, size = " + localArrayList.size());
      return localArrayList;
      label211:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.getResources().getDrawable(2130841451);
    }
  }
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      SLog.d("Q.qqstory.record.StoryDoodle", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      SLog.d("Q.qqstory.record.StoryDoodle", "create folder : " + bool);
    }
  }
  
  private void e()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null)
    {
      SLog.b("Q.qqstory.record.StoryDoodle", "makeSureInitLayout");
      localObject1 = this.jdField_a_of_type_AndroidViewViewStub.getParent();
      if ((localObject1 == null) || (!(localObject1 instanceof ViewGroup))) {
        break label188;
      }
    }
    label188:
    for (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());; this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = ((DoodleLayout)a(2131302938)))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a.a(7, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleBitmapMaxSize(720, 1280);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceFaceListPage$FacePackagePageEventListener);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setAdapter(this.jdField_a_of_type_Iuw);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicSize(16);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setMosaicStandardSize(480, 640);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setDoodleEventListener(this);
      localObject1 = Dispatchers.get();
      Object localObject2 = new iuv(this);
      this.jdField_a_of_type_Iuv = ((iuv)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      localObject1 = Dispatchers.get();
      localObject2 = new iuu(this);
      this.jdField_a_of_type_Iuu = ((iuu)localObject2);
      ((Dispatcher)localObject1).registerSubscriber((Subscriber)localObject2);
      return;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
  }
  
  public DoodleLayout a()
  {
    e();
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b();
    }
  }
  
  public void a(int paramInt)
  {
    SLog.b("Q.qqstory.record.StoryDoodle", "onStateChanged : " + paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.o();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a.h();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setViewActive(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_AndroidWidgetImageView, true);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.d(true);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setViewActive(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_AndroidWidgetImageView, false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a.d();
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setViewActive(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_AndroidWidgetImageView, false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a.e();
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setViewActive(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_AndroidWidgetImageView, false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a.f();
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setViewActive(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_AndroidWidgetImageView, false);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a.b(new int[] { 4 });
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a.g();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2: 
    case 3: 
    default: 
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, "表情个数已达上限", 0).a();
  }
  
  public void a(View paramView)
  {
    e();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setViewActive(paramView, true);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setAllViewsActive(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setLeftBackIcon(true);
    MusicComposeDialog localMusicComposeDialog = new MusicComposeDialog(paramView.getContext());
    localMusicComposeDialog.setCanceledOnTouchOutside(true);
    localMusicComposeDialog.setOnDismissListener(new ius(this, paramView));
    localMusicComposeDialog.setCancelable(true);
    localMusicComposeDialog.show();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y) {}
    for (paramView = "2";; paramView = "1")
    {
      ReportController.b(null, "dc00899", "grp_story", "", "video_edit", "clk_music", 0, 0, paramView, "", "", "");
      return;
    }
  }
  
  public void a(LocationFacePackage.Item paramItem)
  {
    SLog.c("Q.qqstory.record.StoryDoodle", "onLocationFaceSelected");
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a("显示地理位置贴图...");
    QQStoryContext.a().a().a(paramItem.d, new iut(this, paramItem));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y) {}
    for (paramString = "2";; paramString = "1")
    {
      StoryReportor.a("video_edit", "exp_editpoi", 0, 0, new String[] { paramString });
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiList$SelectLocationCallback);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    VideoSourceHelper.nativeSetMosaic(16, this.jdField_a_of_type_ArrayOfByte);
  }
  
  public boolean a(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a());
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
  }
  
  public void b()
  {
    e();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(0);
    this.jdField_a_of_type_Iuw.a(a(false));
  }
  
  public void b(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.b(paramNewStoryTakeVideoActivity);
    b(b);
    paramNewStoryTakeVideoActivity = (DoodleEmojiManager)SuperManager.a(8);
    paramNewStoryTakeVideoActivity.a(BaseApplicationImpl.a());
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131302937));
    this.jdField_a_of_type_Iuw = new iuw(null);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage = new LocationFacePackage("Location-Package");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_Boolean = true;
      String str = DoodleEmojiManager.a((StoryConfigManager)SuperManager.a(10), "0");
      if (TextUtils.isEmpty(str)) {
        break label128;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.c = str;
    }
    for (;;)
    {
      Looper.myQueue().addIdleHandler(new iup(this, paramNewStoryTakeVideoActivity));
      return;
      label128:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceLocationFacePackage.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.getResources().getDrawable(2130841451);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setVisibility(8);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.d();
  }
  
  public void g(NewStoryTakeVideoActivity paramNewStoryTakeVideoActivity)
  {
    super.g(paramNewStoryTakeVideoActivity);
    if (this.jdField_a_of_type_Iuv != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Iuv);
    }
    if (this.jdField_a_of_type_Iuu != null) {
      Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Iuu);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a().setDownloadListener(null);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout = null;
    }
    this.jdField_a_of_type_Iuw = null;
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryDoodle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */