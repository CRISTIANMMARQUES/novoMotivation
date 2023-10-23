package com.example.novomotivation.infra

class MotivationConstants private constructor(){ //siguinifica que nenhuma outra classe poderá instanciar
    
    object KEY{
        const val USER_NAME = "USER_NAME"
    }

    object FILTER{
        const val ALL = 1
        const val HAPPY = 2
        const val SUNNY = 3
    }
}