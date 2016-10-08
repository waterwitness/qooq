package com.tencent.mobileqq.activity.photo;

import android.os.AsyncTask;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import orv;

public class PhotoListActivity$QueryPhotoTask
  extends AsyncTask
{
  public PhotoListActivity$QueryPhotoTask(PhotoListActivity paramPhotoListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected List a(Object... paramVarArgs)
  {
    LogTag.a();
    int i = -1;
    if (this.a.m.equals("$RecentAlbumId")) {
      i = 100;
    }
    paramVarArgs = AlbumUtil.c(this.a, this.a.m, this.a.l, i, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter);
    LogTag.a("PEAK", "getAlbumMedias");
    if (paramVarArgs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      return null;
    }
    Object localObject;
    int j;
    if ((this.a.c != null) && (this.a.c.size() != 0)) {
      for (i = 0; i < this.a.c.size(); i = j + 1)
      {
        localObject = (String)this.a.c.get(i);
        j = i;
        if (!new File((String)localObject).exists()) {
          if ((((String)localObject).startsWith("http")) && (this.a.jdField_a_of_type_JavaUtilHashMap != null))
          {
            j = i;
            if (this.a.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {}
          }
          else
          {
            this.a.c.remove(i);
            j = i - 1;
          }
        }
      }
    }
    if (this.a.E)
    {
      i = paramVarArgs.size() - 1;
      while (i >= 0)
      {
        localObject = (LocalMediaInfo)paramVarArgs.get(i);
        if ((!((LocalMediaInfo)localObject).jdField_a_of_type_JavaLangString.endsWith(".gif")) && ((((LocalMediaInfo)localObject).j < this.a.w) || (((LocalMediaInfo)localObject).i < this.a.v))) {
          paramVarArgs.remove(i);
        }
        if ((((LocalMediaInfo)localObject).jdField_a_of_type_JavaLangString.endsWith(".gif")) && (((LocalMediaInfo)localObject).jdField_b_of_type_Long > this.a.jdField_x_of_type_Int)) {
          paramVarArgs.remove(i);
        }
        i -= 1;
      }
    }
    this.a.jdField_t_of_type_Int = 0;
    long l1 = System.currentTimeMillis();
    long l2 = AlbumUtil.c;
    if (AlbumUtil.jdField_a_of_type_JavaUtilHashMap.containsKey(this.a.m)) {}
    for (int k = ((Integer)AlbumUtil.jdField_a_of_type_JavaUtilHashMap.get(this.a.m)).intValue();; k = 0)
    {
      int n = paramVarArgs.size();
      localObject = new ArrayList(n);
      i = 0;
      int m = 0;
      if (m < paramVarArgs.size())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramVarArgs.get(m);
        if (localLocalMediaInfo.jdField_a_of_type_JavaLangString == null) {}
        for (;;)
        {
          m += 1;
          break;
          int i1 = AlbumUtil.a(localLocalMediaInfo);
          if (i1 == 0)
          {
            ((ArrayList)localObject).add(localLocalMediaInfo.jdField_a_of_type_JavaLangString);
            j = i;
          }
          for (;;)
          {
            localLocalMediaInfo.jdField_a_of_type_JavaLangInteger = Integer.valueOf(m - j);
            if (!this.a.c.contains(localLocalMediaInfo.jdField_a_of_type_JavaLangString)) {
              break label654;
            }
            localLocalMediaInfo.jdField_b_of_type_Int = 1;
            if (!this.a.d.contains(localLocalMediaInfo.jdField_a_of_type_JavaLangInteger)) {
              this.a.d.add(localLocalMediaInfo.jdField_a_of_type_JavaLangInteger);
            }
            i = j;
            if (!this.a.D) {
              break;
            }
            i = j;
            if (i1 != 1) {
              break;
            }
            PhotoListActivity localPhotoListActivity = this.a;
            localPhotoListActivity.jdField_t_of_type_Int += 1;
            i = j;
            if (this.a.jdField_t_of_type_Int != 1) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = localLocalMediaInfo;
            i = j;
            break;
            j = i;
            if (i1 == 1) {
              j = i + 1;
            }
          }
          label654:
          if ((this.a.c.size() < this.a.n) && (this.a.jdField_x_of_type_JavaLangString != null) && (localLocalMediaInfo.jdField_a_of_type_JavaLangString.equals(this.a.jdField_x_of_type_JavaLangString)))
          {
            localLocalMediaInfo.jdField_b_of_type_Int = 1;
            this.a.c.add(localLocalMediaInfo.jdField_a_of_type_JavaLangString);
            this.a.d.add(localLocalMediaInfo.jdField_a_of_type_JavaLangInteger);
            i = j;
          }
          else if ((this.a.jdField_q_of_type_Boolean) && (l1 - l2 <= 60000L) && (k == paramVarArgs.size()) && (localLocalMediaInfo.jdField_a_of_type_JavaLangString.equals(AlbumUtil.jdField_a_of_type_JavaLangString)))
          {
            localLocalMediaInfo.jdField_b_of_type_Int = 3;
            i = j;
          }
          else
          {
            localLocalMediaInfo.jdField_b_of_type_Int = 2;
            i = j;
          }
        }
      }
      if (n > 1000) {
        PhotoListActivity.jdField_a_of_type_JavaUtilArrayList = (ArrayList)localObject;
      }
      for (this.a.jdField_t_of_type_Boolean = true;; this.a.jdField_t_of_type_Boolean = false)
      {
        return paramVarArgs;
        this.a.b = ((ArrayList)localObject);
      }
    }
  }
  
  protected void a(List paramList)
  {
    int m = 0;
    this.a.d();
    Object localObject;
    if (paramList == null)
    {
      localObject = paramList;
      if (this.a.jdField_x_of_type_Boolean)
      {
        localObject = paramList;
        if (this.a.m.equals("$RecentAlbumId"))
        {
          paramList = new LocalMediaInfo();
          paramList.jdField_b_of_type_JavaLangString = "mobileqq/camera";
          localObject = new ArrayList();
          ((List)localObject).add(0, paramList);
        }
      }
      this.a.jdField_a_of_type_Orv.a((List)localObject);
      this.a.jdField_a_of_type_Orv.notifyDataSetChanged();
      this.a.e();
      QQToast.a(this.a, "暂无媒体文件", 1000).a();
      return;
    }
    if (((this.a.jdField_x_of_type_Boolean) || (this.a.E)) && (this.a.m.equals("$RecentAlbumId")))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).jdField_b_of_type_JavaLangString = "mobileqq/camera";
      paramList.add(0, localObject);
    }
    this.a.jdField_a_of_type_Orv.a(paramList);
    int i;
    if (paramList.isEmpty())
    {
      QQToast.a(this.a, "暂无媒体文件", 1000).a();
      if (this.a.f)
      {
        this.a.f = false;
        if (this.a.u != -1) {
          break label583;
        }
        i = PhotoListActivity.jdField_q_of_type_Int;
        label244:
        if (i != -1) {
          break label612;
        }
        localObject = (LinkedHashMap)AlbumUtil.b.get(this.a.m);
        if (localObject == null) {
          break label653;
        }
        j = ((LinkedHashMap)localObject).size();
        if (j <= 0) {
          break label653;
        }
      }
    }
    label339:
    label440:
    label471:
    label583:
    label594:
    label612:
    label653:
    for (int j = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(j - 1)])).intValue();; j = i)
    {
      i = j;
      int k;
      if (j == -1)
      {
        i = j;
        if (this.a.jdField_q_of_type_Boolean)
        {
          localObject = paramList.iterator();
          k = 0;
          i = j;
          if (((Iterator)localObject).hasNext())
          {
            if (((LocalMediaInfo)((Iterator)localObject).next()).jdField_b_of_type_Int != 3) {
              break label594;
            }
            i = k;
          }
        }
      }
      if ((i == -1) && (this.a.m.equals("$RecentAlbumId")) && (!this.a.c.isEmpty()))
      {
        k = paramList.size();
        localObject = (String)this.a.c.get(this.a.c.size() - 1);
        j = 0;
        if (j < k) {
          if (((String)localObject).equals(((LocalMediaInfo)paramList.get(j)).jdField_a_of_type_JavaLangString)) {
            i = j;
          }
        }
      }
      for (;;)
      {
        j = this.a.jdField_a_of_type_Orv.getCount();
        if (j == 0) {
          j = m;
        }
        for (;;)
        {
          this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(j);
          this.a.jdField_a_of_type_Orv.notifyDataSetChanged();
          this.a.e();
          return;
          if ((!this.a.E) || (paramList.size() != 1)) {
            break;
          }
          QQToast.a(this.a, "暂无媒体文件", 1000).a();
          if (this.a.e == null) {
            break;
          }
          this.a.e.setVisibility(8);
          break;
          i = this.a.u;
          break label244;
          k += 1;
          break label339;
          j += 1;
          break label440;
          PhotoListActivity.jdField_q_of_type_Int = -1;
          break label471;
          if (i > j - 1)
          {
            j -= 1;
          }
          else
          {
            j = m;
            if (i >= 0) {
              j = i;
            }
          }
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.c();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\photo\PhotoListActivity$QueryPhotoTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */