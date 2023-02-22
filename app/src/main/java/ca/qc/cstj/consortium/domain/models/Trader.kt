package ca.qc.cstj.consortium.domain.models

import kotlin.random.Random

data class Trader(
    var name: String,
    var blierium: Float = 200.00f,
    var vethyx: Float = 200.00f,
    var kreotrium: Float = 200.00f,
    var smiathil: Float = 200.00f,
    var laspyx: Float = 200.00f
) {

    fun reload(){
        blierium = Random.nextInt(50,201).toFloat()
        vethyx = Random.nextInt(50,201).toFloat()
        kreotrium = Random.nextInt(50,201).toFloat()
        smiathil = Random.nextInt(50,201).toFloat()
        laspyx = Random.nextInt(50,201).toFloat()
    }

}