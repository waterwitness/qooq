package cooperation.qqfav.globalsearch;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;

public class FavoriteSearchResultPresenter
  extends SearchResultPresenter
{
  private BitmapFactory.Options a;
  
  public FavoriteSearchResultPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new BitmapFactory.Options();
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    paramISearchResultView.e().setMaxWidth(800);
    FavoriteSearchResultModel localFavoriteSearchResultModel = (FavoriteSearchResultModel)paramISearchResultModel;
    ImageView localImageView = paramISearchResultView.a();
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if ((5 == localFavoriteSearchResultModel.f) || (localFavoriteSearchResultModel.jdField_a_of_type_Boolean)) {
      localImageView.setImageResource(2130840288);
    }
    while (localFavoriteSearchResultModel.jdField_d_of_type_JavaLangString != null)
    {
      paramISearchResultModel = URLDrawable.URLDrawableOptions.obtain();
      paramISearchResultModel.mRequestHeight = paramISearchResultView.a().getHeight();
      paramISearchResultModel.mRequestWidth = paramISearchResultView.a().getWidth();
      if ((5 == localFavoriteSearchResultModel.f) || (localFavoriteSearchResultModel.jdField_a_of_type_Boolean))
      {
        localImageView.setBackgroundDrawable(URLDrawable.getDrawable(localFavoriteSearchResultModel.jdField_d_of_type_JavaLangString, paramISearchResultModel));
        return;
        localImageView.setImageDrawable(null);
        localImageView.setBackgroundDrawable(null);
      }
      else
      {
        localImageView.setImageDrawable(URLDrawable.getDrawable(localFavoriteSearchResultModel.jdField_d_of_type_JavaLangString, paramISearchResultModel));
        return;
      }
    }
    if (localFavoriteSearchResultModel.jdField_d_of_type_Int != 0)
    {
      if ((5 == localFavoriteSearchResultModel.f) || (localFavoriteSearchResultModel.jdField_a_of_type_Boolean))
      {
        localImageView.setBackgroundResource(localFavoriteSearchResultModel.jdField_d_of_type_Int);
        return;
      }
      localImageView.setImageResource(localFavoriteSearchResultModel.jdField_d_of_type_Int);
      return;
    }
    if (localFavoriteSearchResultModel.jdField_a_of_type_ArrayOfByte != null)
    {
      this.a.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(localFavoriteSearchResultModel.jdField_a_of_type_ArrayOfByte, 0, localFavoriteSearchResultModel.jdField_a_of_type_ArrayOfByte.length, this.a);
      this.a.inJustDecodeBounds = false;
      this.a.inSampleSize = (this.a.outWidth / paramISearchResultView.a().getMeasuredWidth());
      try
      {
        paramISearchResultModel = new BitmapDrawable(null, BitmapFactory.decodeByteArray(localFavoriteSearchResultModel.jdField_a_of_type_ArrayOfByte, 0, localFavoriteSearchResultModel.jdField_a_of_type_ArrayOfByte.length, this.a));
        if ((5 == localFavoriteSearchResultModel.f) || (localFavoriteSearchResultModel.jdField_a_of_type_Boolean))
        {
          localImageView.setBackgroundDrawable(paramISearchResultModel);
          return;
        }
      }
      catch (OutOfMemoryError paramISearchResultModel)
      {
        for (;;)
        {
          paramISearchResultModel = null;
        }
        localImageView.setImageDrawable(paramISearchResultModel);
        return;
      }
    }
    super.b(paramISearchResultModel, paramISearchResultView);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqfav\globalsearch\FavoriteSearchResultPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */