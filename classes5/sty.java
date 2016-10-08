import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.HotChatMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.widget.TroopMemberListSlideItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class sty
  extends CharDividedFacePreloadBaseAdapter
{
  private String jdField_a_of_type_JavaLangString;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap;
  int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public sty(HotChatMemberListActivity paramHotChatMemberListActivity)
  {
    super(paramHotChatMemberListActivity, paramHotChatMemberListActivity.app, paramHotChatMemberListActivity.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.getString(2131367351);
    a();
  }
  
  private void a()
  {
    int n = 1;
    int m = 0;
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject1 = null;
    int i = 0;
    int k = 0;
    int j = 0;
    for (;;)
    {
      Object localObject3;
      Object localObject2;
      if (localIterator.hasNext())
      {
        localObject3 = (sts)localIterator.next();
        if (((sts)localObject3).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.app.a()))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.j == 2)
          {
            localObject1 = localObject3;
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.e = ((sts)localObject3).jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.jdField_a_of_type_Byte = ((sts)localObject3).jdField_a_of_type_Byte;
        }
        if (((sts)localObject3).jdField_a_of_type_Int == 1)
        {
          localArrayList.add(0, localObject3);
          j = 1;
          continue;
        }
        if (((sts)localObject3).jdField_a_of_type_Int == 2)
        {
          localArrayList.add(localObject3);
          k = 1;
          continue;
        }
        if (((sts)localObject3).jdField_a_of_type_Boolean)
        {
          if (!localArrayList.contains(localObject3))
          {
            localArrayList.add(localObject3);
            i = 1;
          }
        }
        else
        {
          if ((((sts)localObject3).c == null) || (((sts)localObject3).c.length() == 0))
          {
            localObject2 = "#";
            label239:
            int i1 = ((String)localObject2).charAt(0);
            if (((65 > i1) || (i1 > 90)) && ((97 > i1) || (i1 > 122))) {
              break label342;
            }
          }
          label342:
          for (localObject2 = ((String)localObject2).toUpperCase();; localObject2 = "#")
          {
            if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2) == null) {
              this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject2, new ArrayList());
            }
            ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject2)).add(localObject3);
            break;
            localObject2 = ((sts)localObject3).c.substring(0, 1);
            break label239;
          }
        }
      }
      else
      {
        if (localObject1 != null) {
          this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.jdField_a_of_type_JavaUtilList.remove(localObject1);
        }
        localObject3 = new StringBuilder();
        localObject2 = "";
        localObject1 = localObject2;
        if (localArrayList != null)
        {
          localObject1 = localObject2;
          if (localArrayList.size() > 0)
          {
            Collections.sort(localArrayList, new stt(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity, null));
            if (j != 0) {
              ((StringBuilder)localObject3).append("房主");
            }
            if (i != 0)
            {
              if (((StringBuilder)localObject3).length() > 0) {
                ((StringBuilder)localObject3).append("、");
              }
              ((StringBuilder)localObject3).append("嘉宾");
            }
            if (k != 0)
            {
              if (((StringBuilder)localObject3).length() > 0) {
                ((StringBuilder)localObject3).append("、");
              }
              ((StringBuilder)localObject3).append("管理员");
            }
            if (localArrayList.size() > 1) {
              ((StringBuilder)localObject3).append("(").append(localArrayList.size()).append("人").append(")");
            }
            localObject1 = ((StringBuilder)localObject3).toString();
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, localArrayList);
          }
        }
        localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (!((String)localObject3).equals(localObject1)) {
            Collections.sort((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject3), new stu(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity, null));
          }
        }
        localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
        this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
        if (((LinkedHashMap)localObject2).get(localObject1) != null) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, ((LinkedHashMap)localObject2).get(localObject1));
        }
        for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
          if (((LinkedHashMap)localObject2).get(String.valueOf(c)) != null) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), ((LinkedHashMap)localObject2).get(String.valueOf(c)));
          }
        }
        if (((LinkedHashMap)localObject2).get("#") != null) {
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", ((LinkedHashMap)localObject2).get("#"));
        }
        ((LinkedHashMap)localObject2).clear();
        this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
        localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (this.jdField_a_of_type_ArrayOfInt.length == 0) {}
        for (;;)
        {
          return;
          this.jdField_a_of_type_ArrayOfInt[0] = 0;
          i = n;
          while (i < this.jdField_a_of_type_ArrayOfInt.length)
          {
            localObject2 = this.jdField_a_of_type_ArrayOfInt;
            j = localObject2[i];
            k = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
            localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + k + 1 + j);
            i += 1;
          }
          localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
          i = m;
          while (((Iterator)localObject1).hasNext())
          {
            this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)((Iterator)localObject1).next());
            i += 1;
          }
        }
      }
      i = 1;
    }
  }
  
  public int a()
  {
    return 2130903393;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  public Bitmap a(String paramString, int paramInt, byte paramByte)
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.app.getManager(50);
    if ((localObject != null) && (((FriendsManager)localObject).b(paramString)) && (!this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.app.a().equals(paramString))) {
      localObject = super.a(paramString, paramInt, paramByte);
    }
    Bitmap localBitmap;
    do
    {
      return (Bitmap)localObject;
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, paramString, 200);
      localObject = localBitmap;
    } while (localBitmap != null);
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 200, true, false);
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  protected Object a(int paramInt)
  {
    sts localsts = (sts)getItem(paramInt);
    CharDividedFacePreloadBaseAdapter.FaceInfo localFaceInfo = new CharDividedFacePreloadBaseAdapter.FaceInfo(this);
    if (localsts != null) {
      localFaceInfo.jdField_a_of_type_JavaLangString = localsts.jdField_a_of_type_JavaLangString;
    }
    return localFaceInfo;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (sts)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    View localView = paramView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904194, paramViewGroup, false);
      paramView = new stz(null);
      localView.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem = ((TroopMemberListSlideItem)localView.findViewById(2131298608));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297779));
      paramView.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131298136));
      paramView.c = ((TextView)localView.findViewById(2131297466));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131301786));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131305214));
      paramView.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131301787));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131301783);
      paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131298072);
      paramView.e = ((TextView)localView.findViewById(2131301785));
    }
    paramView = (stz)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      paramViewGroup = (sts)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramView.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(paramViewGroup.jdField_a_of_type_JavaLangString, 1, (byte)0));
      paramView.c.setText(paramViewGroup.jdField_b_of_type_JavaLangString);
      paramView.jdField_b_of_type_JavaLangString = paramViewGroup.jdField_a_of_type_JavaLangString;
      paramView.jdField_d_of_type_AndroidWidgetTextView.setTag(new String[] { paramViewGroup.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_b_of_type_JavaLangString });
      paramView.jdField_a_of_type_AndroidViewView.setTag(new String[] { paramViewGroup.jdField_a_of_type_JavaLangString, paramViewGroup.jdField_b_of_type_JavaLangString });
      paramView.jdField_b_of_type_AndroidViewView.setTag(paramViewGroup.jdField_a_of_type_JavaLangString);
      if (HotChatMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity, paramViewGroup) == 1)
      {
        paramView.e.setText("房主");
        paramView.e.setBackgroundResource(2130843475);
        paramView.e.setPadding(10, 2, 10, 2);
        if ((!this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.d) || (paramViewGroup.jdField_a_of_type_Int != 0)) {
          break label654;
        }
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.jdField_b_of_type_AndroidViewView.setClickable(true);
        if (!this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.f.equals(paramViewGroup.jdField_a_of_type_JavaLangString)) {
          break label643;
        }
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.a(false);
        label511:
        paramView = paramView.jdField_b_of_type_AndroidWidgetImageView;
        if (this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity.jdField_a_of_type_Byte != 1) {
          break label690;
        }
      }
      label643:
      label654:
      label690:
      for (paramInt = 0;; paramInt = 8)
      {
        paramView.setVisibility(paramInt);
        return localView;
        if (HotChatMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity, paramViewGroup) == 3)
        {
          paramView.e.setText("管理员");
          paramView.e.setBackgroundResource(2130843474);
          paramView.e.setPadding(10, 2, 10, 2);
          break;
        }
        if (HotChatMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqHotchatHotChatMemberListActivity, paramViewGroup) == 2)
        {
          paramView.e.setText("嘉宾");
          paramView.e.setBackgroundResource(2130843474);
          paramView.e.setPadding(10, 2, 10, 2);
          break;
        }
        paramView.e.setVisibility(8);
        break;
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        break label511;
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.b(false);
        paramView.jdField_b_of_type_AndroidViewView.setOnClickListener(null);
        paramView.jdField_b_of_type_AndroidViewView.setClickable(false);
        break label511;
      }
    }
    paramView.jdField_a_of_type_ComTencentMobileqqWidgetTroopMemberListSlideItem.setVisibility(8);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
    paramView.e.setVisibility(8);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */