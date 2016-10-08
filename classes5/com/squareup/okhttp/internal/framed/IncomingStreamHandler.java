package com.squareup.okhttp.internal.framed;

import java.io.IOException;

public abstract interface IncomingStreamHandler
{
  public static final IncomingStreamHandler REFUSE_INCOMING_STREAMS = new IncomingStreamHandler()
  {
    public void receive(FramedStream paramAnonymousFramedStream)
      throws IOException
    {
      paramAnonymousFramedStream.close(ErrorCode.REFUSED_STREAM);
    }
  };
  
  public abstract void receive(FramedStream paramFramedStream)
    throws IOException;
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\internal\framed\IncomingStreamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */