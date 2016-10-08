package ct;

import android.location.Location;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;

final class bq
  extends bp
{
  private SparseArray<Pair<Double, Double>> a = new SparseArray();
  
  public bq(String paramString)
  {
    super(paramString, "check cell");
  }
  
  public final void a()
  {
    super.a();
    this.a.clear();
  }
  
  protected final boolean a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("lac");
    int j = paramBundle.getInt("cid");
    paramBundle = (Location)paramBundle.getParcelable("location");
    if ((i == 0) || (j == 0)) {
      return false;
    }
    if (paramBundle == null) {
      return true;
    }
    i <<= j + 16;
    Pair localPair = (Pair)this.a.get(i);
    if (localPair == null)
    {
      paramBundle = Pair.create(Double.valueOf(paramBundle.getLatitude()), Double.valueOf(paramBundle.getLongitude()));
      this.a.put(i, paramBundle);
      if (this.a.size() > 320) {
        this.a.delete(this.a.keyAt(0));
      }
      return true;
    }
    return b.a(paramBundle.getLatitude(), paramBundle.getLongitude(), ((Double)localPair.first).doubleValue(), ((Double)localPair.second).doubleValue()) < 6000.0D;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */