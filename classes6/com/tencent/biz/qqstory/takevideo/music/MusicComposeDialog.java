package com.tencent.biz.qqstory.takevideo.music;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.network.request.GetMusicConfigRequest;
import com.tencent.biz.qqstory.network.response.GetMusicConfigResponse;
import com.tencent.biz.qqstory.takevideo.NewStoryImagePlayerModule;
import com.tencent.biz.qqstory.takevideo.NewStoryPartManager;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import iyg;
import iyh;
import iyi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

public class MusicComposeDialog
  extends Dialog
  implements AdapterView.OnItemClickListener, DownloadProgressListener, CmdTaskManger.CommandCallback, MusicHorizontalSeekView.SeekListener
{
  protected static final float a = 0.05F;
  protected static final int a = 1;
  public static QQStoryMusicInfo a;
  public static ArrayList a;
  public static boolean a = false;
  protected static final int b = 2;
  protected static final int c = 3;
  protected static final int d = 6;
  protected static final int e = 7;
  protected static final int f = 8;
  protected static final int g = 9;
  public static int h = 1;
  protected long a;
  protected BroadcastReceiver a;
  public Handler a;
  public View a;
  protected GridView a;
  public ProgressBar a;
  public TextView a;
  public DownloaderImp a;
  public NewStoryTakeVideoActivity a;
  protected MusicComposeDialog.MusicPlayTask a;
  public MusicGridAdapter a;
  public MusicHorizontalSeekView a;
  protected HashMap a;
  protected Timer a;
  protected long b;
  public View b;
  public TextView b;
  protected HashMap b;
  public boolean b;
  protected TextView c;
  public boolean c;
  protected TextView d;
  public int i;
  public int j;
  protected volatile int k;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public MusicComposeDialog(Context paramContext)
  {
    super(paramContext, 2131558944);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler = new iyg(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new iyi(this);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity = ((NewStoryTakeVideoActivity)paramContext);
    a(paramContext);
    WindowManager.LayoutParams localLayoutParams = super.getWindow().getAttributes();
    localLayoutParams.x = 0;
    localLayoutParams.y = 0;
    localLayoutParams.width = -1;
    localLayoutParams.height = AIOUtils.a(211.0F, paramContext.getResources());
    localLayoutParams.windowAnimations = 16973824;
    localLayoutParams.gravity = 83;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  public static void d()
  {
    h = -1;
    jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = null;
    if (jdField_a_of_type_JavaUtilArrayList != null)
    {
      jdField_a_of_type_JavaUtilArrayList.clear();
      jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public int a()
  {
    if (this.i < 5000) {
      return 5000;
    }
    return this.i;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.q();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int m = (int)(this.jdField_c_of_type_AndroidWidgetTextView.getPaint().measureText("00:00") / 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt1 - m);
    this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.d.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt2 - m);
    this.d.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b();
    c();
    b(paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y) {}
    for (String str = "2";; str = "1")
    {
      ReportController.b(null, "dc00899", "grp_story", "", "video_edit", "cut_music", 0, 0, str, "", "", "");
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130904459, null);
    super.setContentView(localView);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y;
    this.i = ((int)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a());
    long l;
    int m;
    if (this.i < 5000)
    {
      l = this.i / 6;
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131302805));
      this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131302806);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)localView.findViewById(2131302807));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131302804));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302808));
      this.d = ((TextView)super.findViewById(2131302809));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301728));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = localView.findViewById(2131302803);
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131302811));
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter = new MusicGridAdapter(paramContext, this.jdField_a_of_type_AndroidWidgetGridView, this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(null);
      if (h == -1)
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label431;
        }
        m = 0;
        label303:
        h = m;
      }
      if ((jdField_a_of_type_JavaUtilArrayList != null) && (!jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        break label463;
      }
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity)) {
        break label436;
      }
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      paramContext = new GetMusicConfigRequest();
      CmdTaskManger.a().a(paramContext, this);
    }
    for (;;)
    {
      paramContext = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      paramContext.addAction("action_music_start");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramContext);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "mVideoLength = " + this.i);
      }
      return;
      l = 1000L;
      break;
      label431:
      m = 1;
      break label303;
      label436:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, "当前无网络", 0).a();
      continue;
      label463:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void a(GetMusicConfigRequest paramGetMusicConfigRequest, GetMusicConfigResponse paramGetMusicConfigResponse, ErrorMessage paramErrorMessage)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onCmdRespond = ").append(System.currentTimeMillis() - this.jdField_b_of_type_Long).append(", errorMsg = ");
      if (paramErrorMessage != null) {
        break label181;
      }
    }
    label181:
    for (paramGetMusicConfigRequest = "null";; paramGetMusicConfigRequest = paramErrorMessage.getErrorMessage())
    {
      QLog.d("zivonchen", 2, paramGetMusicConfigRequest);
      ReportController.b(null, "dc00899", "grp_story", "", "edit_video", "music_list_time", 0, 0, String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "", "", "");
      if ((paramErrorMessage == null) || (!paramErrorMessage.isFail())) {
        break;
      }
      paramGetMusicConfigRequest = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramGetMusicConfigRequest.obj = ("onCmdRespond error = " + paramErrorMessage.getErrorMessage());
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramGetMusicConfigRequest);
      ReportController.b(null, "dc00899", "grp_story", "", "edit_video", "music_list_failed", 0, 0, "", "", "", "");
      return;
    }
    paramGetMusicConfigResponse = paramGetMusicConfigResponse.a;
    int n = paramGetMusicConfigResponse.music_config.size();
    paramGetMusicConfigRequest = new ArrayList(n);
    if (n > 0)
    {
      int m = 0;
      while (m < n)
      {
        paramGetMusicConfigRequest.add(new QQStoryMusicInfo((qqstory_struct.MusicConfigInfo)paramGetMusicConfigResponse.music_config.get(m)));
        m += 1;
      }
      if (QLog.isColorLevel())
      {
        paramGetMusicConfigResponse = new StringBuffer();
        paramGetMusicConfigResponse.append("GetMusicConfigResponse size = " + n);
        m = 0;
        while (m < n)
        {
          paramErrorMessage = (QQStoryMusicInfo)paramGetMusicConfigRequest.get(m);
          paramGetMusicConfigResponse.append(", " + m + ": title = " + paramErrorMessage.b + ", audioUrl = " + paramErrorMessage.d);
          m += 1;
        }
        QLog.d("zivonchen", 2, paramGetMusicConfigResponse.toString());
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00899", "grp_story", "", "edit_video", "music_list_count", 0, 0, String.valueOf(n), "", "", "");
      jdField_a_of_type_JavaUtilArrayList = paramGetMusicConfigRequest;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    Object localObject2;
    if ((paramQQStoryMusicInfo != null) && (!TextUtils.isEmpty(paramQQStoryMusicInfo.d)))
    {
      localObject2 = QQStoryBGMusicUtils.a(paramQQStoryMusicInfo.d);
      localObject1 = (QQStoryMusicInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramQQStoryMusicInfo.d);
      if ((localObject1 == null) || (TextUtils.isEmpty(((QQStoryMusicInfo)localObject1).jdField_g_of_type_JavaLangString))) {
        break label143;
      }
    }
    label143:
    for (Object localObject1 = ((QQStoryMusicInfo)localObject1).jdField_g_of_type_JavaLangString; com.tencent.mobileqq.shortvideo.ptvfilter.utils.FileUtils.a((String)localObject1); localObject1 = localObject2)
    {
      localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      paramQQStoryMusicInfo.jdField_g_of_type_JavaLangString = ((String)localObject1);
      ((Message)localObject2).obj = paramQQStoryMusicInfo;
      ((Message)localObject2).arg1 = -1;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "exists audio_url = " + paramQQStoryMusicInfo.d + ", path = " + (String)localObject1);
      }
      return;
    }
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, "当前无网络", 0).a();
      return;
    }
    jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = null;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramQQStoryMusicInfo.b);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_JavaUtilHashMap.put(paramQQStoryMusicInfo.d, Long.valueOf(System.currentTimeMillis()));
    this.jdField_a_of_type_JavaUtilHashMap.put(paramQQStoryMusicInfo.d, paramQQStoryMusicInfo);
    ThreadManager.a(new iyh(this, paramQQStoryMusicInfo, (String)localObject2), 5, null, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onDownloadFinish() url = " + paramString);
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    String str = QQStoryBGMusicUtils.a(paramString);
    QQStoryMusicInfo localQQStoryMusicInfo = (QQStoryMusicInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    localQQStoryMusicInfo.jdField_g_of_type_JavaLangString = str;
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = localQQStoryMusicInfo;
    localMessage.arg1 = -1;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    if (paramInt == 0) {
      ReportController.b(null, "dc00899", "grp_story", "", "edit_video", "music_download_success", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(paramString)).longValue();
        QLog.d("zivonchen", 2, "onDownloadFinish errCode = " + paramInt + ", name = " + com.tencent.mobileqq.shortvideo.ptvfilter.utils.FileUtils.b(paramString) + ", downloadTime = " + (System.currentTimeMillis() - l) + ", fileSize = " + com.tencent.biz.qqstory.utils.FileUtils.a(str) + new StringBuilder().append(", url = ").append(paramString).toString());
      }
      return;
      ReportController.b(null, "dc00899", "grp_story", "", "edit_video", "music_download_failed", 0, 0, String.valueOf(paramInt), "", "", "");
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    if (f1 >= this.k * 0.05F)
    {
      this.k += 1;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      paramString.arg1 = ((int)(100.0F * f1));
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onProgress() mIndex = " + this.k + ", progress = " + f1 + ", cur = " + paramLong1 + ", size = " + paramLong2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onDownloadStart() url = " + paramString1 + ", dstPath = " + paramString2);
    }
    this.k = 0;
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
    paramString1.arg1 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.a.c();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.a.a();
  }
  
  public void b()
  {
    f();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.r();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int n = paramInt2 - paramInt1 + paramInt1 / 1000 * 1000;
    int m = n;
    if (n - paramInt1 < 1000) {
      m = n + 1000;
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "start = " + paramInt1 + ", end = " + paramInt2 + ", displayEnd = " + m);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(QQStoryBGMusicUtils.a(paramInt1));
    this.d.setText(QQStoryBGMusicUtils.a(m));
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null)
    {
      paramInt2 = jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.i;
      jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_g_of_type_Int = ((int)(paramInt2 * (paramInt3 / paramInt1)));
      jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.h = (jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_g_of_type_Int + this.i);
      b(jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_g_of_type_Int, jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.h);
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.a.a.a.b();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    a();
    a(true);
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    f();
    a(true);
    super.dismiss();
  }
  
  public void e()
  {
    f();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog$MusicPlayTask = new MusicComposeDialog.MusicPlayTask(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog$MusicPlayTask, 0L, this.jdField_a_of_type_Long);
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog$MusicPlayTask != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog$MusicPlayTask.cancel();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicComposeDialog$MusicPlayTask = null;
    }
    this.j = -1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter != null)
    {
      paramAdapterView = (QQStoryMusicInfo)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.getItem(paramInt);
      if (paramAdapterView != null) {
        break label57;
      }
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "onItemClick error musicInfo = " + null);
      }
    }
    label57:
    do
    {
      return;
      h = paramInt;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(h);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
      if (paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a()) {
        break;
      }
      b();
      if (paramAdapterView.f == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y) {}
        for (paramAdapterView = "2";; paramAdapterView = "1")
        {
          ReportController.b(null, "dc00899", "grp_story", "", "video_edit", "close_music", 0, 0, paramAdapterView, "", "", "");
          return;
        }
      }
      if (paramAdapterView.f == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y) {}
        for (paramAdapterView = "2";; paramAdapterView = "1")
        {
          ReportController.b(null, "dc00899", "grp_story", "", "video_edit", "clk_video_sound", 0, 0, paramAdapterView, "", "", "");
          return;
        }
      }
    } while (paramAdapterView.f != 2);
    if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity, "当前无网络", 0).a();
      return;
    }
    jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    VideoSourceHelper.nativeSetPlayAFMute(jdField_a_of_type_Boolean);
    b();
    QQStoryBGMusicUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y) {}
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      ReportController.b(null, "dc00899", "grp_story", "", "video_edit", "add_qqmusic", 0, 0, paramAdapterView, "", "", "");
      return;
    }
    jdField_a_of_type_Boolean = true;
    VideoSourceHelper.nativeSetPlayAFMute(jdField_a_of_type_Boolean);
    b();
    a(paramAdapterView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryTakeVideoActivity.y) {}
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      ReportController.b(null, "dc00899", "grp_story", "", "video_edit", "add_music", 0, 0, paramAdapterView, "", "", "");
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\music\MusicComposeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */