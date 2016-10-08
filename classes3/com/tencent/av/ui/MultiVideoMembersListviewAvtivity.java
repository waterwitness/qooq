package com.tencent.av.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gxa;
import gxb;
import gxc;
import gxd;
import gxe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import mqq.app.BaseActivity;

public class MultiVideoMembersListviewAvtivity
  extends BaseActivity
{
  static final String jdField_a_of_type_JavaLangString = "MultiVideoMembersListviewAvtivity";
  public static final String c = "KEY_ISFORSELECT";
  public static final String d = "KEY_ISFORGVIDEO";
  public int a;
  public long a;
  public LayoutInflater a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  AdapterView.OnItemClickListener jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener;
  ListView jdField_a_of_type_AndroidWidgetListView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public VideoController a;
  GAudioUIObserver jdField_a_of_type_ComTencentAvAppGAudioUIObserver;
  public VideoAppInterface a;
  public gxe a;
  public ArrayList a;
  public boolean a;
  TextView b;
  public String b;
  
  public MultiVideoMembersListviewAvtivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Gxe = null;
    this.jdField_a_of_type_AndroidWidgetListView = null;
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new gxc(this);
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = new gxd(this);
  }
  
  void a()
  {
    Intent localIntent = super.getIntent();
    if (localIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersListviewAvtivity", 2, "can not get intent");
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("RelationUin");
        if (this.jdField_b_of_type_JavaLangString != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("MultiVideoMembersListviewAvtivity", 2, "processExtraData-->can not get relationuin from intent");
      return;
      this.jdField_a_of_type_Long = Long.valueOf(this.jdField_b_of_type_JavaLangString).longValue();
      this.jdField_a_of_type_Int = localIntent.getIntExtra("UinType", -1);
    } while ((this.jdField_a_of_type_Int != -1) || (!QLog.isColorLevel()));
    QLog.e("MultiVideoMembersListviewAvtivity", 2, "processExtraData-->can not get uintype from intent");
  }
  
  public void b()
  {
    super.finish();
  }
  
  public void c()
  {
    String str = String.format(super.getResources().getString(2131363678), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.b().size()) });
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Boolean = super.getIntent().getBooleanExtra("KEY_ISFORGVIDEO", false);
    if (this.jdField_a_of_type_Boolean) {
      super.setContentView(2130903564);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)super.getAppRuntime());
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersListviewAvtivity", 2, "onCreate-->can not get the VideoAppInterface");
      }
      super.finish();
      return;
      super.setContentView(2130903580);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.d == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersListviewAvtivity", 2, "onCreate-->VideoAppInterface.PROC_STATUS_CAN_CLOSED");
      }
      super.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersListviewAvtivity", 2, "onCreate-->can not get the VideoController");
      }
      super.finish();
      return;
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(super.getApplicationContext());
    a();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299260));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299261));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)super.findViewById(2131299263));
    this.jdField_a_of_type_Gxe = new gxe(this);
    paramBundle = this.jdField_a_of_type_ComTencentAvVideoController.b();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    boolean bool = super.getIntent().getBooleanExtra("KEY_ISFORSELECT", false);
    VideoController.GAudioFriends localGAudioFriends;
    if (bool)
    {
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localGAudioFriends = (VideoController.GAudioFriends)paramBundle.next();
        if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().equals(String.valueOf(localGAudioFriends.jdField_a_of_type_Long))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localGAudioFriends);
        }
      }
    }
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      localGAudioFriends = (VideoController.GAudioFriends)paramBundle.next();
      this.jdField_a_of_type_JavaUtilArrayList.add(localGAudioFriends);
    }
    if (this.jdField_a_of_type_Boolean) {
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, new gxa(this));
    }
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Gxe);
    if (!bool) {}
    for (paramBundle = String.format(super.getResources().getString(2131363678), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });; paramBundle = super.getResources().getString(2131363940))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramBundle);
      this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = new gxb(this, bool);
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_Gxe = null;
    this.jdField_a_of_type_AndroidWidgetListView = null;
    this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    this.jdField_a_of_type_ComTencentAvAppGAudioUIObserver = null;
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\ui\MultiVideoMembersListviewAvtivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */