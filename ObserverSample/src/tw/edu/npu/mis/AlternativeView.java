/*
 * Copyright (c) 2015, STP
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package tw.edu.npu.mis;


/**
 *
 * @author STP
 */
public class AlternativeView implements Observer, Show{
    private final Model mModel;
    //private boolean mIsValid;
    
    private final String mName;
    private final Window mWindow;
    String s="";//宣告字串s
    //private final Model mModel;
    
    /*public AlternativeView(Model model) {
        mModel = model;
        mModel.attach(this);
    }*/
    public AlternativeView(String name, Window window, Model model) {
        mName = name;
        mWindow = window;
        mModel = model;
        mModel.attach(this);//mModel使用Subject裡的attach方法(加入AlternativeView)
    }
    
  private void invalidate() {
        mWindow.schduleRedraw(this);
        }
    

    
    @Override
    public void update() {
        invalidate();
        //mIsValid = false;
    }

    @Override
    public void OnDraw() {
      if(!s.equals(mModel.getData())){//判斷輸入是否與舊字串相同或為空值
          s=mModel.getData();//不同則把輸入丟入s
     
      System.out.println("AlternativeView "+ new StringBuilder(mModel.getData()).reverse());//印出顛倒字串
    }
   }
}