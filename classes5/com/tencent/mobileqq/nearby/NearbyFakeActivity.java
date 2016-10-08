package com.tencent.mobileqq.nearby;

import EncounterSvc.RespGetEncounterV2;
import NeighborComm.RespHeader;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NearPeopleFilterActivity.NearPeopleFilters;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.NearbyObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import thn;
import tho;

public class NearbyFakeActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 5000;
  public static final String a;
  public static final int b = 3000;
  public static final String b = "resultreceiver_nearbyfakeactivity";
  public static final int c = 1000;
  public static final int d = 8000;
  public static final int e = 6000;
  public static final int f = 5000;
  public static final int g = 0;
  public static final int h = 0;
  public static final int i = 1;
  private long jdField_a_of_type_Long;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Handler jdField_a_of_type_AndroidOsHandler = new thn(this);
  NearbyObserver jdField_a_of_type_ComTencentMobileqqAppNearbyObserver = new tho(this);
  NearbyResultReceiver jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver;
  public Object a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private final int j = 0;
  private final int k = 1;
  private final int l = 2;
  private final int m = 3;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = NearbyFakeActivity.class.getSimpleName();
  }
  
  public NearbyFakeActivity()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private NearPeopleFilterActivity.NearPeopleFilters a()
  {
    if (((Boolean)NearbySPUtil.a(this.app.getAccount(), "history_valid", Boolean.valueOf(false))).booleanValue()) {}
    NearPeopleFilterActivity.NearPeopleFilters localNearPeopleFilters2;
    for (NearPeopleFilterActivity.NearPeopleFilters localNearPeopleFilters1 = NearPeopleFilterActivity.NearPeopleFilters.a(this, this.app.a());; localNearPeopleFilters1 = null)
    {
      localNearPeopleFilters2 = localNearPeopleFilters1;
      if (localNearPeopleFilters1 == null)
      {
        localNearPeopleFilters2 = new NearPeopleFilterActivity.NearPeopleFilters();
        if (((Integer)NearbySPUtil.a(this.app.getAccount(), "self_gender", Integer.valueOf(0))).intValue() - 1 != 0) {
          break;
        }
        localNearPeopleFilters2.i = 2;
      }
      return localNearPeopleFilters2;
    }
    localNearPeopleFilters2.i = 0;
    return localNearPeopleFilters2;
  }
  
  private void a(int paramInt)
  {
    int n = 0;
    if ((this.jdField_a_of_type_Boolean) || (isFinishing())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "OpenNearbyAct from:" + paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_Boolean = true;
    try
    {
      startActivity(this.jdField_a_of_type_AndroidContentIntent);
      overridePendingTransition(0, 0);
      long l1 = System.currentTimeMillis();
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Long <= 0L)) {
        this.jdField_c_of_type_Long = (l1 - this.jdField_a_of_type_Long);
      }
      if (this.jdField_b_of_type_Long <= 0L) {
        this.jdField_b_of_type_Long = (l1 - this.jdField_a_of_type_Long);
      }
      if (paramInt == 2)
      {
        bool = true;
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_NetType", NetworkUtil.a(null) + "");
        localHashMap.put("param_DeviceType", StatisticConstants.a() + "");
        if (this.jdField_b_of_type_Boolean) {
          break label361;
        }
        n = 1;
        localHashMap.put("param_enterType", n + "");
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(getCurrentAccountUin(), "CMD_PRELOAD_NEARBY", true, this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "OpenNearbyAct timeout:" + bool + ", mPreloadProcTime:" + this.jdField_b_of_type_Long + " mPreloadDataTime:" + this.jdField_c_of_type_Long);
        }
        finish();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        if (QLog.isColorLevel())
        {
          QLog.i(jdField_a_of_type_JavaLangString, 2, localException.getMessage(), localException);
          continue;
          bool = false;
          continue;
          label361:
          if (paramInt == 2) {
            n = 2;
          } else if (paramInt == 1) {
            n = 3;
          } else if (paramInt == 0)
          {
            if (this.e) {
              n = 4;
            } else {
              n = 5;
            }
          }
          else if (paramInt == 3) {
            n = 6;
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    if (a())
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    Intent localIntent = new Intent(paramContext, NearbyFakeActivity.class);
    localIntent.putExtra("intent", paramIntent);
    paramContext.startActivity(localIntent);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramToServiceMsg == null)) {}
    do
    {
      for (;;)
      {
        return;
        if (paramObject != null)
        {
          Object localObject = (Object[])paramObject;
          if (localObject.length < 3) {
            break;
          }
          try
          {
            boolean bool = ((Boolean)localObject[2]).booleanValue();
            paramObject = (RespHeader)localObject[0];
            localObject = (RespGetEncounterV2)localObject[1];
            if ((paramObject != null) && (localObject != null))
            {
              JceOutputStream localJceOutputStream = new JceOutputStream();
              localJceOutputStream.setServerEncoding("utf-8");
              ((RespHeader)paramObject).writeTo(localJceOutputStream);
              paramObject = new JceOutputStream();
              ((JceOutputStream)paramObject).setServerEncoding("utf-8");
              ((RespGetEncounterV2)localObject).writeTo((JceOutputStream)paramObject);
              this.jdField_a_of_type_AndroidContentIntent.putExtra("respHeader", localJceOutputStream.toByteArray());
              this.jdField_a_of_type_AndroidContentIntent.putExtra("respGetEncounter", ((JceOutputStream)paramObject).toByteArray());
              this.jdField_a_of_type_AndroidContentIntent.putExtra("nearbyDataIsSuc", bool);
              this.jdField_a_of_type_AndroidContentIntent.putExtra("FromServiceMsg", paramFromServiceMsg);
              this.jdField_a_of_type_AndroidContentIntent.putExtra("ToServiceMsg", paramToServiceMsg);
              return;
            }
          }
          catch (Exception paramFromServiceMsg) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
  }
  
  public static boolean a()
  {
    return PreloadProcHitSession.a("com.tencent.mobileqq:tool");
  }
  
  private void b()
  {
    setTitle("附近");
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130838587);
    this.rightViewImg.setEnabled(false);
    Drawable localDrawable = getResources().getDrawable(2130838323);
    TextView localTextView = (TextView)findViewById(2131296792);
    this.centerView.setCompoundDrawablePadding(10);
    this.centerView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    ((Animatable)localDrawable).start();
  }
  
  private void c()
  {
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    NearbyHandler localNearbyHandler = (NearbyHandler)this.app.a(89);
    this.jdField_d_of_type_Long = NearbyDataManager.a(this.app, this, localNearbyHandler, true, a(), 0, 0, 0);
  }
  
  public void a()
  {
    this.jdField_b_of_type_Long = (System.currentTimeMillis() - this.jdField_a_of_type_Long);
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_d_of_type_Boolean) {
          break label175;
        }
        if (this.e)
        {
          break label175;
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "procPreload ok. dataDone? " + bool + " needPreloadData:" + this.jdField_b_of_type_Boolean + " consume:" + this.jdField_b_of_type_Long);
          }
          if (QLog.isColorLevel()) {
            NearbyUtils.a("NearbyFakeActivity", "trace", new Object[] { "NearbyFakeActivity.onReceiveResult", Long.valueOf(System.currentTimeMillis()) });
          }
          if ((!this.jdField_b_of_type_Boolean) || (bool)) {
            a(0);
          }
          return;
        }
        bool = false;
      }
      boolean bool = false;
      continue;
      label175:
      bool = true;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903417);
    b();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver = new NearbyResultReceiver(null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver.a(this);
    this.jdField_a_of_type_AndroidContentIntent = ((Intent)getIntent().getParcelableExtra("intent"));
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramBundle = new Intent(this, NearbyReceiver.class);
    paramBundle.putExtra("nearby_preload_from", 2);
    paramBundle.putExtra("resultreceiver_nearbyfakeactivity", this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver);
    BaseApplicationImpl.getContext().sendBroadcast(paramBundle);
    if (QLog.isColorLevel()) {
      NearbyUtils.a("NearbyFakeActivity", "trace", new Object[] { "NearbyFakeActivity.doOnCreate", Long.valueOf(this.jdField_a_of_type_Long) });
    }
    int n = StatisticConstants.a();
    if (n >= 2) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
    }
    while (NetworkUtil.e(this))
    {
      c();
      if (n >= 2)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
        return true;
        if (n >= 1) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 6000L);
        } else {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 8000L);
        }
      }
      else
      {
        if (n >= 1)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 3000L);
          return true;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 5000L);
        return true;
      }
    }
    this.jdField_b_of_type_Boolean = false;
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyResultReceiver.a(null);
    }
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearbyObserver);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.doOnDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\nearby\NearbyFakeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */