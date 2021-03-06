package com.juanleodev.marvelheroes.data.web.mapper

import com.juanleodev.marvelheroes.data.web.model.hero.*
import org.junit.Assert.*
import org.junit.Test

class HeroesMapperTest {

    @Test
    fun mapToHeroListTestResultIsEmptyList() {
        val result = HeroesMapper.mapToHeroList(
            CharacterDataWrapper(),
            HeroesMapper.ImageQuality.PORTRAIT_MEDIUM,
            HeroesMapper.ImageQuality.PORTRAIT_MEDIUM
        )
        assertTrue(result.isEmpty())
    }

    @Test
    fun mapToHeroListTestMapSuccess() {
        val characterDataWrapper = createCharacterDataWrapperWithNCharacters(2)

        val result = HeroesMapper.mapToHeroList(characterDataWrapper,
            HeroesMapper.ImageQuality.PORTRAIT_MEDIUM,
            HeroesMapper.ImageQuality.PORTRAIT_MEDIUM
        )

        assertTrue(result.isNotEmpty())
        assertEquals(characterDataWrapper.data?.results?.get(0)?.id, result[0].id)
        assertEquals(characterDataWrapper.data?.results?.get(1)?.id, result[1].id)
    }

    private fun createCharacterDataWrapperWithNCharacters(size: Int): CharacterDataWrapper {
        val items: ArrayList<Character> = ArrayList()
        for (i in 0..size) {
            items.add(Character(i))
        }

        return CharacterDataWrapper(
            data = CharacterDataContainer(
                results = items
            )
        )
    }

    @Test
    fun mapImageTestNullImage() {
        val result = HeroesMapper.mapImage(null, HeroesMapper.ImageQuality.PORTRAIT_MEDIUM)
        assertNull(result)
    }

    @Test
    fun mapImageTestNullPath() {
        val image = Image(null, "jpg")
        val result = HeroesMapper.mapImage(image, HeroesMapper.ImageQuality.PORTRAIT_MEDIUM)
        assertNull(result)
    }

    @Test
    fun mapImageTestNullExtension() {
        val image = Image("https://anypath.com/imageId", null)
        val result = HeroesMapper.mapImage(image, HeroesMapper.ImageQuality.PORTRAIT_MEDIUM)
        assertNull(result)
    }

    @Test
    fun mapImageTestSuccess() {
        val expected = "https://anypath.com/imageId/portrait_medium.jpg"
        val image = Image("https://anypath.com/imageId", "jpg")
        val result = HeroesMapper.mapImage(image, HeroesMapper.ImageQuality.PORTRAIT_MEDIUM)
        assertEquals(expected, result)
    }

    @Test
    fun mapComicsTestResultIsEmptyList() {
        val result = HeroesMapper.mapComics(ComicList())
        assertTrue(result.isEmpty())
    }

    @Test
    fun mapComicsTestMapSucess() {
        val comicList = createComicListWithNComics(2)

        val result = HeroesMapper.mapComics(comicList)
        assertEquals(comicList.items?.get(0)?.name, result[0].name)
        assertEquals(comicList.items?.get(1)?.name, result[1].name)
    }

    private fun createComicListWithNComics(size: Int): ComicList {
        val items: ArrayList<ComicSummary> = ArrayList()
        for (i in 0..size) {
            items.add(ComicSummary(name = "name_$i"))
        }

        return ComicList(items = items)
    }

    @Test
    fun mapStoriesTestResultIsEmptyList() {
        val result = HeroesMapper.mapStories(StoryList())
        assertTrue(result.isEmpty())
    }

    @Test
    fun mapStoriesTestMapSuccess() {
        val storyList = createStoryListWithNcomics(2)

        val result = HeroesMapper.mapStories(storyList)
        assertEquals(storyList.items?.get(0)?.name, result[0].name)
        assertEquals(storyList.items?.get(1)?.name, result[1].name)
    }

    private fun createStoryListWithNcomics(size: Int): StoryList {
        val items: ArrayList<StorySummary> = ArrayList()
        for (i in 0..size) {
            items.add(StorySummary(name = "name_$i"))
        }

        return StoryList(items = items)
    }

    @Test
    fun mapSeriesTestResultIsEmptyList() {
        val result = HeroesMapper.mapSeries(SeriesList())
        assertTrue(result.isEmpty())
    }

    @Test
    fun mapSeriesTestMapSuccess() {
        val seriesList = createSeriesListWithNcomics(2)

        val result = HeroesMapper.mapSeries(seriesList)
        assertEquals(seriesList.items?.get(0)?.name, result[0].name)
        assertEquals(seriesList.items?.get(1)?.name, result[1].name)
    }

    private fun createSeriesListWithNcomics(size: Int): SeriesList {
        val items: ArrayList<SeriesSummary> = ArrayList()
        for (i in 0..size) {
            items.add(SeriesSummary(name = "name_$i"))
        }

        return SeriesList(items = items)
    }

}