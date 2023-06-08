package com.example.fetch_apprenticeship.suite


import com.example.fetch_apprenticeship.data.api.FetchApiTest
import com.example.fetch_apprenticeship.data.local.ListDaoTest
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
    ListDaoTest::class,
    FetchApiTest::class
)
class MainSuite {
}