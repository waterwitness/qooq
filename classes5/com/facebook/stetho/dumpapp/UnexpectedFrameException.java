package com.facebook.stetho.dumpapp;

class UnexpectedFrameException
  extends DumpappFramingException
{
  public UnexpectedFrameException(byte paramByte1, byte paramByte2)
  {
    super("Expected '" + paramByte1 + "', got: '" + paramByte2 + "'");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\dumpapp\UnexpectedFrameException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */