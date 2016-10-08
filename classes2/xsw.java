import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class xsw
  extends Filter
{
  xsx a;
  
  public xsw(xsx paramxsx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramxsx;
  }
  
  public CharSequence convertResultToString(Object paramObject)
  {
    return this.a.a((Cursor)paramObject);
  }
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = this.a.a(paramCharSequence);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (paramCharSequence != null)
    {
      localFilterResults.count = paramCharSequence.getCount();
      localFilterResults.values = paramCharSequence;
      return localFilterResults;
    }
    localFilterResults.count = 0;
    localFilterResults.values = null;
    return localFilterResults;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    paramCharSequence = this.a.a();
    if ((paramFilterResults.values != null) && (paramFilterResults.values != paramCharSequence)) {
      this.a.a((Cursor)paramFilterResults.values);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xsw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */