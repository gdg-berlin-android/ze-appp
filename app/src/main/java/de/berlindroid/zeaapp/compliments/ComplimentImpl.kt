package de.berlindroid.zeaapp.compliments

class ComplimentImpl : ComplimentProvider {
    override fun getCompliment(): String {
        return "Cheer up!"
    }
}