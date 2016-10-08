import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.presenter.IPresenter;
import com.tencent.mobileqq.search.view.IView;
import com.tencent.mobileqq.search.view.SearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import cooperation.qqfav.globalsearch.FavoriteSearchFragment;
import cooperation.qqfav.globalsearch.FavoriteSearchResultModel;
import cooperation.qqfav.globalsearch.FavoriteSearchResultPresenter;

public class ygo
  extends BaseMvpFaceAdapter
  implements View.OnClickListener
{
  public ygo(FavoriteSearchFragment paramFavoriteSearchFragment, ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    super(paramListView, paramFaceDecoder);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected IPresenter a(int paramInt)
  {
    return new FavoriteSearchResultPresenter(FavoriteSearchFragment.a(this.a));
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    return new SearchResultView(paramViewGroup, 2130904950);
  }
  
  public int getCount()
  {
    int i = super.getCount();
    if ((i > 0) && (((FavoriteSearchResultModel)super.a(i - 1)).a == -2L))
    {
      i -= 1;
      if (i == 0) {
        FavoriteSearchFragment.a(this.a);
      }
      return i;
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == super.getCount() - 1) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (getItemViewType(paramInt) == 1)
    {
      Object localObject;
      if (paramView == null)
      {
        localObject = new TextView(paramViewGroup.getContext());
        ((TextView)localObject).setTextSize(18.0F);
        ((TextView)localObject).setTextColor(paramViewGroup.getResources().getColor(2131428285));
        ((TextView)localObject).setGravity(1);
        ((TextView)localObject).setClickable(true);
        ((TextView)localObject).setOnClickListener(this);
        ((TextView)localObject).setPadding(0, 16, 0, 16);
        paramView = (View)localObject;
        paramViewGroup = paramView;
        if (((FavoriteSearchResultModel)super.a(paramInt)).a != -1L) {
          break label118;
        }
        paramViewGroup.performClick();
      }
      label118:
      do
      {
        return (View)localObject;
        paramViewGroup = (TextView)paramView;
        localObject = paramView;
        break;
        paramViewGroup.setText(2131366030);
        paramView = (Animatable)paramViewGroup.getCompoundDrawables()[1];
        paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      } while (paramView == null);
      paramView.stop();
      return (View)localObject;
    }
    return super.getView(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    paramView = (TextView)paramView;
    paramView.setText(null);
    Animatable localAnimatable = (Animatable)BaseApplicationImpl.a.getResources().getDrawable(2130838321);
    paramView.setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localAnimatable, null, null);
    localAnimatable.start();
    paramView = (FavoriteSearchEngine)FavoriteSearchFragment.a(this.a);
    FavoriteSearchFragment.a(this.a).a = FavoriteSearchFragment.a(this.a);
    paramView.a(FavoriteSearchFragment.a(this.a), this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\ygo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */