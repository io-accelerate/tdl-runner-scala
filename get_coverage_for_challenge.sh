#!/usr/bin/env bash

set -x
set -e
set -u
set -o pipefail

SCRIPT_CURRENT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

CHALLENGE_ID=$1
SCOVERAGE_REPORT_XML_FILE="${SCRIPT_CURRENT_DIR}/target/scala-3.6.2/scoverage-report/scoverage.xml"
SCALA_CODE_COVERAGE_INFO="${SCRIPT_CURRENT_DIR}/coverage.tdl"

( cd ${SCRIPT_CURRENT_DIR} && sbt clean coverage test || sbt coverageReport)

[ -e ${SCALA_CODE_COVERAGE_INFO} ] && rm ${SCALA_CODE_COVERAGE_INFO}

if [ -f "${SCOVERAGE_REPORT_XML_FILE}" ]; then
    COVERAGE_PERCENT=$(( 0 ))
    echo ${COVERAGE_PERCENT} > ${SCALA_CODE_COVERAGE_INFO}
    COVERAGE_OUTPUT=$(xmllint --xpath '//package[@name="io.accelerate.solutions.'${CHALLENGE_ID}'"]/@statement-rate' ${SCOVERAGE_REPORT_XML_FILE})
    if [[ ! -z "${COVERAGE_OUTPUT}" ]]; then
        COVERAGE_PERCENT=$(echo ${COVERAGE_OUTPUT} | tr '".' ' ' | tr -s ' ' | awk '{printf "%.0f", $2}')
        COVERAGE_PERCENT=$(( ${COVERAGE_PERCENT} + 0 ))
    fi
    echo ${COVERAGE_PERCENT} > ${SCALA_CODE_COVERAGE_INFO}
    cat ${SCALA_CODE_COVERAGE_INFO}
    exit 0
else
    echo "No coverage report was found"
    exit 255
fi
