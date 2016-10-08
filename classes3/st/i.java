package st;

final class i
{
  private static final int[] a = { 93629, 99879, 79843, 75029, 59699, 55667, 46867, 38039 };
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    if (paramArrayOfByte == null)
    {
      arrayOfByte = null;
      return arrayOfByte;
    }
    int i = 0;
    for (;;)
    {
      arrayOfByte = paramArrayOfByte;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ a[(i & 0x7)] & 0xFF));
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */