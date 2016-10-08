package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.text.Editable;
import android.text.style.ForegroundColorSpan;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rhb;

public class DragSortAdapter
  extends BaseAdapter
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  public Context a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private Object jdField_a_of_type_JavaLangObject;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  protected List a;
  JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private int f;
  
  public DragSortAdapter(Context paramContext, List paramList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(30);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new rhb(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838153);
    ClubContentJsonTask.b((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime(), ClubContentJsonTask.e);
    paramContext = ClubContentJsonTask.e.a(this.jdField_a_of_type_AndroidContentContext);
    if (paramContext != null) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONArray = paramContext.getJSONArray("wording");
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.f = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428280);
      return;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private int a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage)
  {
    int j = 1;
    if (((EmojiManager)paramQQAppInterface.getManager(42)).a(paramEmoticonPackage.epId) >= 0.0F) {}
    boolean bool;
    for (int i = 1;; i = 0)
    {
      bool = EmoticonUtils.a(paramEmoticonPackage);
      if (paramEmoticonPackage.status != 2) {
        break label54;
      }
      if (!bool) {
        break;
      }
      return 0;
    }
    return 4;
    label54:
    if (bool)
    {
      if (i != 0) {}
      for (i = j;; i = 0) {
        return i;
      }
    }
    if (i != 0) {}
    for (i = 2;; i = 3) {
      return i;
    }
  }
  
  private Drawable a(EmoticonPackage paramEmoticonPackage)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramEmoticonPackage.epId) != null) {
      return (Drawable)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramEmoticonPackage.epId);
    }
    Drawable localDrawable = EmosmUtils.a(2, paramEmoticonPackage.epId);
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramEmoticonPackage.epId, localDrawable);
      return localDrawable;
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private View a(XListView paramXListView, EmoticonPackage paramEmoticonPackage)
  {
    int j = paramXListView.s();
    int i = j;
    while (i <= paramXListView.t())
    {
      Object localObject = ((DragSortItemView)paramXListView.getChildAt(i - j)).getChildAt(0);
      if (((View)localObject).getTag() != null)
      {
        localObject = (DragSortAdapter.ViewHolder)((View)localObject).getTag();
        if (((DragSortAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.getTag() != null)
        {
          EmoticonPackage localEmoticonPackage = (EmoticonPackage)((DragSortAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.getTag();
          if (paramEmoticonPackage.epId.equals(localEmoticonPackage.epId)) {
            return ((DragSortAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProgressButton;
          }
        }
      }
      i += 1;
    }
    return null;
  }
  
  private DownloaderInterface a()
  {
    return ((DownloaderFactory)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime()).getManager(46)).a(1);
  }
  
  private String a(String paramString, int paramInt1, int paramInt2, ProgressButton paramProgressButton)
  {
    int i = 1;
    int j = ((SVIPHandler)((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime()).a(13)).h();
    if (paramInt1 == 4) {
      if ((j != 1) && (j != 3)) {
        i = 1;
      }
    }
    for (;;)
    {
      String str = paramString;
      if (paramInt2 == 4)
      {
        if (i == 0) {
          break label119;
        }
        if (paramInt1 != 4) {
          break label108;
        }
        paramString = "服务已过期，请开通会员";
      }
      for (;;)
      {
        paramProgressButton.setVisibility(4);
        str = paramString;
        return str;
        i = 0;
        break;
        if (paramInt1 != 5) {
          break label180;
        }
        if (j != 3) {
          break;
        }
        for (;;)
        {
          i = 0;
        }
        label108:
        if (paramInt1 == 5) {
          paramString = "服务已过期，请开通超级会员";
        }
      }
      switch (paramInt1)
      {
      default: 
        return paramString;
      case 1: 
        return "长期有效";
      case 2: 
        return "付费下载";
      case 3: 
        return "限免";
      case 4: 
        return "VIP免费使用";
      case 5: 
        label119:
        return "SVIP免费使用";
      }
      return "活动";
      label180:
      i = 0;
    }
  }
  
  private String a(String paramString, ProgressButton paramProgressButton, View paramView, EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage.valid)
    {
      paramProgressButton.setText(2131370276);
      paramProgressButton.setTextColor(this.f);
      QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();
      int i = a(localQQAppInterface, paramEmoticonPackage);
      if ((i == 1) || (i == 2))
      {
        paramProgressButton.setProgress((int)(((EmojiManager)localQQAppInterface.getManager(42)).a(paramEmoticonPackage.epId) * 100.0F));
        paramProgressButton.setText(2131370278);
      }
      while (this.jdField_a_of_type_Boolean)
      {
        paramView.setVisibility(8);
        return paramString;
        if (i == 0)
        {
          paramProgressButton.setProgress(0);
          paramProgressButton.setText(2131370276);
          if (!"".equals(paramEmoticonPackage.updateTip)) {
            paramString = paramEmoticonPackage.updateTip;
          }
        }
        else if (i == 3)
        {
          paramProgressButton.setProgress(0);
          paramProgressButton.setText(2131370277);
        }
        else
        {
          paramProgressButton.setProgress(0);
          paramProgressButton.setText(2131370279);
          paramProgressButton.setTextColor(-3355444);
        }
      }
      paramView.setVisibility(0);
      paramProgressButton.setVisibility(0);
      return paramString;
    }
    paramView.setVisibility(8);
    return paramString;
  }
  
  private static String a(JSONArray paramJSONArray, long paramLong1, long paramLong2)
  {
    Object localObject;
    if (paramLong1 == -1L) {
      localObject = "";
    }
    for (;;)
    {
      return (String)localObject;
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = 1L;
      }
      if (paramJSONArray == null) {
        break label276;
      }
      if (l >= 1L) {}
      try
      {
        if (l > paramJSONArray.length())
        {
          if (!QLog.isColorLevel()) {
            break label280;
          }
          QLog.d("DragSortAdapter", 2, "Illegal wordingId,wordingId=" + l + ",listSize=" + paramJSONArray.length());
          break label280;
        }
        str2 = ((JSONObject)paramJSONArray.get((int)l - 1)).getString("desc_mqq");
        localObject = str2;
        if (str2 != null)
        {
          localObject = str2;
          paramJSONArray = str2;
          try
          {
            if (str2.contains("$EXPIRE_DATE$"))
            {
              if (paramLong2 > 0L) {
                break label230;
              }
              str2 = "";
              localObject = str2;
              paramJSONArray = str2;
              if (QLog.isColorLevel())
              {
                paramJSONArray = str2;
                QLog.d("DragSortAdapter", 2, "Illegal expireTime, expireTime=" + paramLong2);
                return "";
              }
            }
          }
          catch (Exception localException1) {}
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          String str2;
          String str1;
          paramJSONArray = "";
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("DragSortAdapter", 2, "Error occurred while parsing wording.json");
    }
    localException1.printStackTrace();
    return paramJSONArray;
    label230:
    paramJSONArray = str2;
    str1 = str2.replaceAll("\\$EXPIRE_DATE\\$", new SimpleDateFormat("yyyy年MM月dd日").format(Long.valueOf(1000L * paramLong2)));
    return str1;
    label276:
    return "";
    label280:
    return "";
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();
    if (paramEmoticonPackage != null)
    {
      ((EmojiManager)localQQAppInterface.getManager(42)).a(paramEmoticonPackage, true);
      if ((paramView instanceof ProgressButton))
      {
        paramEmoticonPackage = (ProgressButton)paramView;
        paramEmoticonPackage.setVisibility(0);
        paramEmoticonPackage.setProgress(0);
        paramEmoticonPackage.setTextColor(this.f);
        paramEmoticonPackage.setText(2131370278);
      }
    }
  }
  
  private void a(EmoticonPackage paramEmoticonPackage, View paramView, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime();
    if (paramEmoticonPackage != null)
    {
      ((EmojiManager)localQQAppInterface.getManager(42)).a(paramEmoticonPackage.epId);
      if ((paramView instanceof ProgressButton))
      {
        paramEmoticonPackage = (ProgressButton)paramView;
        paramEmoticonPackage.setVisibility(0);
        paramEmoticonPackage.setProgress(0);
        paramEmoticonPackage.setTextColor(this.f);
        if (!paramBoolean) {
          break label81;
        }
      }
    }
    label81:
    for (int i = 2131370276;; i = 2131370277)
    {
      paramEmoticonPackage.setText(i);
      return;
    }
  }
  
  private void a(ProgressButton paramProgressButton)
  {
    Object localObject = new Rect();
    paramProgressButton.getHitRect((Rect)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("DragSortAdapter", 2, "===originalRnage====width:" + ((Rect)localObject).width() + " height:" + ((Rect)localObject).height());
    }
    ((Rect)localObject).left += 5;
    ((Rect)localObject).right += 5;
    ((Rect)localObject).bottom += 5;
    ((Rect)localObject).top += 5;
    localObject = new TouchDelegate((Rect)localObject, paramProgressButton);
    if (View.class.isInstance(paramProgressButton.getParent())) {
      ((View)paramProgressButton.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    boolean bool = a(paramInt);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      localHashMap.put(localEmoticonPackage, Boolean.valueOf(bool));
      return;
    }
  }
  
  public void a(XListView paramXListView, EmoticonPackage paramEmoticonPackage)
  {
    if ((paramXListView == null) || (paramEmoticonPackage == null)) {}
    int i;
    do
    {
      DownloadTask localDownloadTask;
      do
      {
        do
        {
          return;
          paramXListView = a(paramXListView, paramEmoticonPackage);
        } while ((paramXListView == null) || (!(paramXListView instanceof ProgressButton)));
        paramXListView = (ProgressButton)paramXListView;
        localDownloadTask = a().a("vipEmoticonKey_" + paramEmoticonPackage.epId);
      } while ((localDownloadTask == null) || (localDownloadTask.b()));
      i = (int)localDownloadTask.a;
      paramXListView.setProgress(i);
      paramXListView.setText(2131370278);
      paramXListView.setTextColor(this.f);
      paramXListView.setVisibility(0);
    } while (!QLog.isColorLevel());
    QLog.d("DragSortAdapter", 2, "down ep=" + paramEmoticonPackage.epId + "progress=" + i);
  }
  
  public void a(XListView paramXListView, EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DragSortAdapter", 2, "epId=" + paramEmoticonPackage.epId + "====pkgId=" + paramEmoticonPackage.epId);
    }
    if ((paramXListView == null) || (paramEmoticonPackage == null)) {}
    do
    {
      do
      {
        return;
        paramXListView = a(paramXListView, paramEmoticonPackage);
      } while ((paramXListView == null) || (!(paramXListView instanceof ProgressButton)));
      paramXListView = (ProgressButton)paramXListView;
      paramXListView.setVisibility(0);
      paramXListView.setProgress(0);
      if (paramInt != 0) {
        break;
      }
      paramXListView.setText(2131370279);
      paramXListView.setTextColor(-3355444);
      ReportController.b((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime(), "CliOper", "", "", "ep_mall", "Clk_pkg_download_aio-mine", 0, 0, paramEmoticonPackage.epId, "", "", "");
    } while (!QLog.isColorLevel());
    QLog.d("DragSortAdapter", 2, "===========report============" + paramEmoticonPackage.epId);
    return;
    paramXListView.setText(2131370277);
    paramXListView.setTextColor(this.f);
  }
  
  public void a(Object paramObject)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramObject instanceof EmoticonPackage)) {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramObject;
      }
      this.jdField_a_of_type_JavaUtilList.remove(paramObject);
      if (this.b) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramInt, paramObject);
      if (this.b) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localEmoticonPackage)) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localEmoticonPackage)).booleanValue();
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    label280:
    String str;
    if (paramView == null)
    {
      localObject = new DragSortAdapter.ViewHolder(this);
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130903352, null);
      ((DragSortAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296971));
      ((DragSortAdapter.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298220));
      ((DragSortAdapter.ViewHolder)localObject).c = ((ImageView)paramView.findViewById(2131296306));
      ((DragSortAdapter.ViewHolder)localObject).d = ((ImageView)paramView.findViewById(2131298221));
      ((DragSortAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProgressButton = ((ProgressButton)paramView.findViewById(2131298226));
      ((DragSortAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298223));
      ((DragSortAdapter.ViewHolder)localObject).e = ((ImageView)paramView.findViewById(2131296972));
      ((DragSortAdapter.ViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298224));
      ((DragSortAdapter.ViewHolder)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131296816);
      ((DragSortAdapter.ViewHolder)localObject).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131298225);
      paramView.setTag(localObject);
      paramViewGroup.setTag(localObject);
      a(((DragSortAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProgressButton);
      ((DragSortAdapter.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup = (ViewGroup)localObject;
      localObject = (EmoticonPackage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setTag(localObject);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((EmoticonPackage)localObject).name);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a((EmoticonPackage)localObject));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (!((EmoticonPackage)localObject).hasSound) {
        break label532;
      }
      paramViewGroup.e.setVisibility(0);
      str = a(a(a(this.jdField_a_of_type_OrgJsonJSONArray, ((EmoticonPackage)localObject).wordingId, ((EmoticonPackage)localObject).expiretime), paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton, paramViewGroup.jdField_b_of_type_AndroidViewView, (EmoticonPackage)localObject), ((EmoticonPackage)localObject).mobileFeetype, ((EmoticonPackage)localObject).jobType, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton);
      long l = new Date().getTime() / 1000L;
      if ((((EmoticonPackage)localObject).expiretime <= l) || ((((EmoticonPackage)localObject).expiretime - l) / 86400L >= 1L)) {
        break label544;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(str, TextView.BufferType.EDITABLE);
      Editable localEditable = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.getEditableText();
      if (str != null) {
        localEditable.setSpan(new ForegroundColorSpan(-65536), 0, str.length(), 18);
      }
      label426:
      if (!this.jdField_a_of_type_Boolean) {
        break label621;
      }
      if (a(paramInt)) {
        break label556;
      }
      paramView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131370272) + " " + ((EmoticonPackage)localObject).name + "," + str);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841699);
    }
    for (;;)
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.c.setVisibility(0);
      return paramView;
      paramViewGroup = (DragSortAdapter.ViewHolder)paramView.getTag();
      break;
      label532:
      paramViewGroup.e.setVisibility(8);
      break label280;
      label544:
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      break label426;
      label556:
      paramView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131370273) + " " + ((EmoticonPackage)localObject).name + "," + str);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841700);
    }
    label621:
    paramView.setContentDescription(((EmoticonPackage)localObject).name + "," + str);
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramViewGroup.c.setVisibility(8);
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.b = true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emosm\view\DragSortAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */