package com.web.sangsang.cmm.entity.constant;

import org.springframework.stereotype.Component;

/**
 * Created by WYKIM on 2017-01-06.
 */
public enum TableNameToClassName {
    SS_GUIDE
    ,SS_LOGGING
    ,SS_MUSEUM
    ,SS_OBJECT
    ,SS_QUIZ
    ,SS_QUIZE_CHOICE
    ,SS_RESOURCE
    ,SS_USER
    ,SS_USER_QUIZ;

    @Override
    public String toString() {
        switch(this) {
            case SS_GUIDE: return "SsGuide";
            case SS_LOGGING: return "SsLogging";
            case SS_MUSEUM: return "SsMuseum";
            case SS_OBJECT: return "SsObject";
            case SS_QUIZ: return "SsQuiz";
            case SS_QUIZE_CHOICE: return "SsQuizChoice";
            case SS_RESOURCE: return "SsResource";
            case SS_USER: return "SsUser";
            case SS_USER_QUIZ: return "SsUserQuiz";
            default: throw new IllegalArgumentException();
        }
    }
}
