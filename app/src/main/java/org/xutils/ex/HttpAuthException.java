/*
 * Copyright (c) 2013. wyouflf (wyouflf@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xutils.ex;

/**
 * 对于的特殊的返回码，作为鉴权信息的设置
 */
public class HttpAuthException extends HttpException {
    private static final long serialVersionUID = 1L;

    public HttpAuthException(int code, String detailMessage, String result) {
        super(code, detailMessage);
        this.setResult(result);
    }
}
