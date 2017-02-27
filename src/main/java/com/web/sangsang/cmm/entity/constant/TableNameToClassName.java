package com.web.sangsang.cmm.entity.constant;

import org.springframework.stereotype.Component;

/**
 * Created by WYKIM on 2017-01-06.
 */
public enum TableNameToClassName {
    SS_GUIDE
    ,SS_THEME
    ,SS_THEME_PLACE
    ,SS_GUIDE_OBJECT
    ,SS_GUIDE_QUIZ
    ,SS_LOGGING
    ,SS_PLACE
    ,SS_OBJECT
    ,SS_QUIZ
    ,SS_QUIZ_CHOICE
    ,SS_RESOURCE
    ,SS_USER
    ,SS_USER_QUIZ;

    @Override
    public String toString() {
        switch(this) {
            case SS_THEME: return "SsTheme";
            case SS_THEME_PLACE: return "SsThemePlace";
            case SS_GUIDE: return "SsGuide";
            case SS_GUIDE_OBJECT: return "SsGuideObject";
            case SS_GUIDE_QUIZ: return "SsGuideQuiz";
            case SS_LOGGING: return "SsLogging";
            case SS_PLACE: return "SsPlace";
            case SS_OBJECT: return "SsObject";
            case SS_QUIZ: return "SsQuiz";
            case SS_QUIZ_CHOICE: return "SsQuizChoice";
            case SS_RESOURCE: return "SsResource";
            case SS_USER: return "SsUser";
            case SS_USER_QUIZ: return "SsUserQuiz";
            default: throw new IllegalArgumentException();
        }
    }
}
