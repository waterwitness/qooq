package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.contact.newfriend.ActivateFriendsItemBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.ContactBindedBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.ContactBindedBuilder.ContactBindedHolder;
import com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder.ContactMatchHolder;
import com.tencent.mobileqq.activity.contact.newfriend.FriendAnniverBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder.NewFriendBaseHolder;
import com.tencent.mobileqq.activity.contact.newfriend.PushRecommendBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.PushRecommendBuilder.PushRecommendHolder;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgItemBuilder;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgItemBuilder.SystemMsgItemHolder;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.newfriend.ActivateFriendMessage;
import com.tencent.mobileqq.newfriend.ContactBindedMessage;
import com.tencent.mobileqq.newfriend.ContactMatchMessage;
import com.tencent.mobileqq.newfriend.FriendAnniverMessage;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.MayKnowMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.XBaseAdapter;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class SystemMsgListAdapter
  extends XBaseAdapter
  implements NewFriendManager.INewFriendListener, IIconListener, FaceDecoder.DecodeTaskCompletionListener, SwipListView.SwipListListener
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "SystemMsgListAdapter";
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  private Context jdField_a_of_type_AndroidContentContext;
  private ContactBindedBuilder jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendContactBindedBuilder;
  public SystemMsgListView a;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public XListView a;
  private Hashtable jdField_a_of_type_JavaUtilHashtable;
  private List jdField_a_of_type_JavaUtilList;
  public int f;
  
  public SystemMsgListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, SystemMsgListView paramSystemMsgListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.f = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = paramSystemMsgListView;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.a(this);
    c();
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt, true, (byte)0);
    }
    return ImageUtil.a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onMayKnowStatesChanged");
    }
    c();
  }
  
  public void a(int paramInt)
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramInt2 == 200) && (paramBitmap != null)) {
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if (paramString != null)
        {
          if (!(paramString instanceof ContactBindedBuilder.ContactBindedHolder)) {
            break label258;
          }
          paramString = (ContactBindedBuilder.ContactBindedHolder)paramString;
          if ((paramString.jdField_a_of_type_JavaLangString != null) && (paramString.jdField_a_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_a_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.jdField_b_of_type_JavaLangString != null) && (paramString.jdField_b_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_b_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.jdField_c_of_type_JavaLangString != null) && (paramString.jdField_c_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_c_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.jdField_d_of_type_JavaLangString != null) && (paramString.jdField_d_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_d_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          label258:
          paramString = (NewFriendBaseBuilder.NewFriendBaseHolder)paramString;
          if ((paramString.jdField_e_of_type_JavaLangString != null) && (paramString.jdField_e_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_e_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.f = i;
      return;
    }
  }
  
  public void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    if ((paramSystemMsgItemHolder == null) || (paramSystemMsgItemHolder.jdField_e_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramSystemMsgItemHolder.a.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((localObject1 != null) && (((FriendsManager)localObject1).b(String.valueOf(paramSystemMsgItemHolder.a.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = ImageUtil.a();
        }
        paramSystemMsgItemHolder.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b())
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(String.valueOf(paramSystemMsgItemHolder.a.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  public void b()
  {
    c();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.a();
    this.jdField_a_of_type_JavaUtilList.clear();
    Iterator localIterator = ((ArrayList)localObject).iterator();
    label259:
    while (localIterator.hasNext())
    {
      NewFriendMessage localNewFriendMessage = (NewFriendMessage)localIterator.next();
      localObject = null;
      if ((localNewFriendMessage instanceof MayKnowMessage)) {
        localObject = new PushRecommendBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localNewFriendMessage);
      }
      for (;;)
      {
        if (localObject == null) {
          break label259;
        }
        this.jdField_a_of_type_JavaUtilList.add(localObject);
        break;
        if ((localNewFriendMessage instanceof ContactMatchMessage)) {
          localObject = new ContactMatchBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localNewFriendMessage);
        } else if ((localNewFriendMessage instanceof ContactBindedMessage))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendContactBindedBuilder == null)
          {
            localObject = new ContactBindedBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localNewFriendMessage);
            this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendContactBindedBuilder = ((ContactBindedBuilder)localObject);
          }
          else
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendContactBindedBuilder;
            ((NewFriendBaseBuilder)localObject).a(localNewFriendMessage);
          }
        }
        else if ((localNewFriendMessage instanceof FriendSystemMessage)) {
          localObject = new SystemMsgItemBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localNewFriendMessage);
        } else if ((localNewFriendMessage instanceof ActivateFriendMessage)) {
          localObject = new ActivateFriendsItemBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localNewFriendMessage);
        } else if ((localNewFriendMessage instanceof FriendAnniverMessage)) {
          localObject = new FriendAnniverBuilder(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localNewFriendMessage);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.i();
    notifyDataSetChanged();
  }
  
  public void d() {}
  
  public void d(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.b(paramBoolean);
      return;
    }
  }
  
  public void e()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      if ((localObject instanceof SystemMsgItemBuilder.SystemMsgItemHolder)) {
        a((SystemMsgItemBuilder.SystemMsgItemHolder)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof ContactMatchBuilder.ContactMatchHolder))
        {
          localObject = (ContactMatchBuilder.ContactMatchHolder)localObject;
          ((ContactMatchBuilder.ContactMatchHolder)localObject).jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactMatchBuilder.ContactMatchHolder)localObject).jdField_e_of_type_JavaLangString));
        }
        else if ((localObject instanceof PushRecommendBuilder.PushRecommendHolder))
        {
          localObject = (PushRecommendBuilder.PushRecommendHolder)localObject;
          ((PushRecommendBuilder.PushRecommendHolder)localObject).jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((PushRecommendBuilder.PushRecommendHolder)localObject).jdField_e_of_type_JavaLangString));
        }
        else if ((localObject instanceof ContactBindedBuilder.ContactBindedHolder))
        {
          localObject = (ContactBindedBuilder.ContactBindedHolder)localObject;
          if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_JavaLangString.length() > 0)) {
            ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_a_of_type_JavaLangString));
          }
          if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_JavaLangString.length() > 0)) {
            ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_b_of_type_JavaLangString));
          }
          if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_JavaLangString.length() > 0)) {
            ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_c_of_type_JavaLangString));
          }
          if ((((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_JavaLangString != null) && (((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_JavaLangString.length() > 0)) {
            ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ContactBindedBuilder.ContactBindedHolder)localObject).jdField_d_of_type_JavaLangString));
          }
        }
      }
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return new Object();
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return ((NewFriendBaseBuilder)getItem(paramInt)).a(paramInt, paramView);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.b(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\adapter\SystemMsgListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */