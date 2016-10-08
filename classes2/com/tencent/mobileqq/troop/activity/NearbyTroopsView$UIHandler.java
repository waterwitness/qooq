package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;
import com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class NearbyTroopsView$UIHandler
  extends Handler
{
  protected WeakReference a;
  
  public NearbyTroopsView$UIHandler(NearbyTroopsView paramNearbyTroopsView1, NearbyTroopsView paramNearbyTroopsView2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramNearbyTroopsView2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 1;
    Object localObject = (NearbyTroopsView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              int j;
              int k;
              int m;
              do
              {
                do
                {
                  return;
                  switch (paramMessage.what)
                  {
                  case 5: 
                  default: 
                    return;
                  case 1: 
                    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.E != 0) {
                      i = 4;
                    }
                    ((NearbyTroopsView)localObject).a(false, i, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.E, false);
                    return;
                  case 3: 
                    ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c();
                    ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.H();
                    return;
                  case 2: 
                    ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c();
                    ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopWidgetNearbyTroopsExpandableListView.H();
                    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.a(1, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_AndroidContentContext.getString(2131369008));
                  }
                } while (!((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d);
                ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.d = false;
                ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.notifyDataSetChanged();
                return;
                paramMessage = paramMessage.getData();
                i = (int)paramMessage.getLong("index", 0L);
                j = (int)paramMessage.getLong("count", 0L);
                k = paramMessage.getInt("lat", 0);
                m = paramMessage.getInt("lon", 0);
                paramMessage = paramMessage.getString("name");
              } while ((i == 0) || (j == 0) || (k == 0) || (m == 0) || (TextUtils.isEmpty(paramMessage)));
              this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramMessage, k, m, i, j, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.E);
              return;
              ((NearbyTroopsView)localObject).jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsBaseView$INearbyTroopContext.c();
              ((NearbyTroopsView)localObject).m();
              return;
              this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqTroopDataNearbyTroopsExpandableListViewAdapter.b(false);
              return;
            } while ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.a().isFinishing()) || ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.e != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.e.getVisibility() == 0)));
            NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView);
            localObject = paramMessage.getData();
          } while ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout == null));
          paramMessage = ((Bundle)localObject).getString("classify_json_data");
          long l = ((Bundle)localObject).getLong("last_modify");
          try
          {
            localObject = new JSONObject(paramMessage);
            NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView, this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.jdField_a_of_type_ComTencentMobileqqWidgetHorizontalScrollLayout, (JSONObject)localObject);
            NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView, paramMessage);
            paramMessage = this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.a().getSharedPreferences("nearby_group_classify_sp", 0).edit();
            paramMessage.putLong("nearby_group_classify_last_modify_time", l);
            paramMessage.commit();
            return;
          }
          catch (Exception paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.e("NearbyTroopsActivity", 2, "MSG_REQUEST_CLASSIFY_DATA_SUCCESS ==>Exception:" + paramMessage.toString());
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.a().isFinishing());
      NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView);
    } while ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.d) || (this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.c == null));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView.c.setVisibility(8);
    return;
    NearbyTroopsView.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityNearbyTroopsView, 0, (Bitmap)paramMessage.obj);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\activity\NearbyTroopsView$UIHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */