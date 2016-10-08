import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SearchTroopListActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.widget.XListView;
import java.util.List;
import tencent.im.kqq.searchgroup.SearchGroup.GroupInfo;

public class mjy
  extends FacePreloadBaseAdapter
{
  public mjy(SearchTroopListActivity paramSearchTroopListActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private CharSequence a(SearchGroup.GroupInfo paramGroupInfo)
  {
    String str = paramGroupInfo.dwCurMemberNum.get() + "人  ";
    if (!paramGroupInfo.bSameCity.get()) {
      return str;
    }
    paramGroupInfo = "[icon]" + " 同城 ";
    paramGroupInfo = new SpannableString(str + paramGroupInfo);
    paramGroupInfo.setSpan(new ImageSpan(this.a, 2130843485, 1), str.length(), str.length() + "[icon]".length(), 17);
    return paramGroupInfo;
  }
  
  private void a(SearchGroup.GroupInfo paramGroupInfo, mka parammka)
  {
    parammka.jdField_a_of_type_TencentImKqqSearchgroupSearchGroup$GroupInfo = paramGroupInfo;
    parammka.jdField_b_of_type_JavaLangString = String.valueOf(paramGroupInfo.dwGroupCode.get());
    Bitmap localBitmap = a(4, String.valueOf(paramGroupInfo.dwGroupCode.get()));
    parammka.d.setBackgroundDrawable(new BitmapDrawable(localBitmap));
    parammka.jdField_a_of_type_AndroidWidgetTextView.setText(paramGroupInfo.sGroupName.get());
    int i;
    if ((paramGroupInfo.dwGroupFlagExt.get() & 0x800) != 0) {
      if (paramGroupInfo.dwAuthGroupType.get() == 2)
      {
        parammka.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parammka.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838906);
        parammka.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramGroupInfo));
        parammka.c.setText(new QQText(paramGroupInfo.sGroupFingerMem.get(), 3));
        int j = paramGroupInfo.dwGroupLevel.get();
        if ((j <= 0) || (j >= 6) || ((paramGroupInfo.dwGroupFlagExt.get() & 0x800000) != 8388608)) {
          break label372;
        }
        i = 2130839761;
        switch (j)
        {
        }
      }
    }
    for (;;)
    {
      paramGroupInfo = this.a.getResources().getDrawable(i);
      paramGroupInfo.setBounds(AIOUtils.a(5.0F, this.a.getResources()), 0, AIOUtils.a(32.5F, this.a.getResources()), AIOUtils.a(16.5F, this.a.getResources()));
      parammka.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, paramGroupInfo, null);
      return;
      if (paramGroupInfo.dwAuthGroupType.get() == 1)
      {
        parammka.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        parammka.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130839365);
        break;
      }
      parammka.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      parammka.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      i = 2130839762;
      continue;
      i = 2130839763;
      continue;
      i = 2130839764;
      continue;
      i = 2130839765;
      continue;
      i = 2130839766;
    }
    label372:
    parammka.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
  }
  
  protected Object a(int paramInt)
  {
    SearchGroup.GroupInfo localGroupInfo = a(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_Int = 4;
    localFaceInfo.jdField_a_of_type_JavaLangString = String.valueOf(localGroupInfo.dwGroupCode.get());
    return localFaceInfo;
  }
  
  public SearchGroup.GroupInfo a(int paramInt)
  {
    return (SearchGroup.GroupInfo)this.a.a.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return ((SearchGroup.GroupInfo)this.a.a.get(paramInt)).dwGroupCode.get();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2130905008, null);
      paramView = new mka(null);
      paramView.d = ((ImageView)localView.findViewById(2131299713));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131299716));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131298260));
      paramView.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131299717));
      paramView.c = ((TextView)localView.findViewById(2131302353));
      paramView.c.setEditableFactory(QQTextBuilder.a);
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(a(paramInt), paramViewGroup);
      return localView;
      paramViewGroup = (mka)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mjy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */