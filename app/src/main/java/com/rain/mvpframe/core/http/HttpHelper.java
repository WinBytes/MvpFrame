/*
 *     (C) Copyright 2019, ForgetSky.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.rain.mvpframe.core.http;


import com.rain.mvpframe.date.bean.ArticleListData;

import io.reactivex.Observable;

public interface HttpHelper {

    /**
     * 获取文章列表
     *
     * @param pageNum 页数
     * @return 文章列表数据
     */
    Observable<BaseResponse<ArticleListData>> getArticleList(int pageNum);


}
