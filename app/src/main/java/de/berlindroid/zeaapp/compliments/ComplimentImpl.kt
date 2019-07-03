package de.berlindroid.zeaapp.compliments

class ComplimentImpl : ComplimentProvider {
    override fun getCompliment(): String {
        return listOf("Cheer up","hey Droidcon").shuffled().first()
    }
}